package dialga.shiny.tutorial.tutorial;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.event.tutorial.TutorialFinishEvent;
import dialga.shiny.tutorial.event.tutorial.TutorialStartEvent;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.tutorial.elements.location.MovementElement;
import dialga.shiny.tutorial.tutorial.elements.observe.ObserverElement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class Tutorial {

    private final String name;
    private final List<StageElement> elements;
    private final Set<Integer> tasks;

    /**
     * Creates a new tutorial.
     * @param name The name of the tutorial.
     * @param elements The list of elements of the tutorial.
     */
    public Tutorial(final String name, final List<StageElement> elements) {
        this.name = name;
        String time = elements.get(elements.size() - 1).getStringDelay();
        elements.add(new ObserverElement(time, false));
        elements.add(new MovementElement(time, true));
        this.elements = elements;
        this.tasks = new HashSet<Integer>();
    }

    /**
     * Get the name of the tutorial.
     * @return The name of the tutorial.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Get the elements of this tutorial.
     * @return The list of elements for this tutorial.
     */
    public final List<StageElement> getElements() {
        return this.elements;
    }

    /**
     * Cancel the tutorial and all subsequent future tasks.
     */
    public void cancel() {
        for (Integer task : tasks) {
            Bukkit.getScheduler().cancelTask(task);
        }
    }

    /**
     * Play the tutorial to the viewer.
     * @param viewer
     */
    public void playTutorial(final Player viewer) {
        TutorialStartEvent event = new TutorialStartEvent(this, viewer);
        TutorialPlugin.getInstance().callEvent(event);
        if (event.isCancelled()) return;
        int delay = 0;
        for (final StageElement element : elements) {
            tasks.add(Bukkit.getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
                public void run() {
                    element.preform(viewer);
                }
            }, delay + element.getTickDelay()));
            delay += element.getTickDelay();
        }
        /** Schedule the finish event. */
        final Tutorial tutorial = this;
        tasks.add(Bukkit.getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                TutorialFinishEvent event = new TutorialFinishEvent(tutorial, viewer);
                TutorialPlugin.getInstance().callEvent(event);
            }
        }, delay));
    }
}
