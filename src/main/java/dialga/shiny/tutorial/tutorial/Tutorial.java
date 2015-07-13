package dialga.shiny.tutorial.tutorial;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.event.tutorial.TutorialFinishEvent;
import dialga.shiny.tutorial.event.tutorial.TutorialStartEvent;
import dialga.shiny.tutorial.listener.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class Tutorial {

    /** The name of the tutorial. */
    protected final String name;
    /** The list of elements, in order, for the tutorial. */
    protected final List<TutorialElement> elements;
    /** The map of tasks for each viewer watching the tutorial. */
    protected final Map<UUID, Set<Integer>> tasks;

    /**
     * Creates a new tutorial.
     * @param name The name of the tutorial.
     * @param elements The list of elements of the tutorial.
     */
    public Tutorial(final String name, final List<TutorialElement> elements) {
        this.name = name;
        this.elements = elements;
        this.tasks = new HashMap<UUID, Set<Integer>>();
    }

    /**
     * Cancel the tutorial for a specific viewer.
     * @param viewer The viewer of the tutorial.
     */
    public void cancel(Player viewer) {
        UUID id = viewer.getUniqueId();
        MetadataUtils.removeMetadata(viewer, TutorialListener.OBSERVE_METADATA);
        MetadataUtils.removeMetadata(viewer, TutorialListener.WALK_METADATA);
        if (tasks.containsKey(id)) {
            for (Integer task : tasks.get(id)) {
                Bukkit.getScheduler().cancelTask(task);
            }
            tasks.remove(id);
        }
    }

    /**
     * Play the tutorial to the viewer.
     * @param viewer
     */
    public void play(final Player viewer) {
        cancel(viewer);
        final Tutorial tutorial = this;
        Set<Integer> playerTasks = new HashSet<Integer>();
        /** Handle tutorial start event. */
        TutorialStartEvent event = new TutorialStartEvent(this, viewer);
        TutorialPlugin.getInstance().callEvent(event);
        if (event.isCancelled()) return;
        /** Schedule all the elements in the tutorial. */
        int delay = 0;
        for (final TutorialElement element : elements) {
            playerTasks.add(Bukkit.getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
                public void run() {
                    element.perform(viewer);
                }
            }, delay + element.getTickDelay()));
            delay += element.getTickDelay();
        }
        /** Schedule tutorial finish event. */
        playerTasks.add(Bukkit.getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                TutorialFinishEvent event = new TutorialFinishEvent(tutorial, viewer);
                TutorialPlugin.getInstance().callEvent(event);
                cancel(viewer);
            }
        }, delay));
        /** Add the task ids to the task map. */
        tasks.put(viewer.getUniqueId(), playerTasks);
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
    public List<TutorialElement> getElements() {
        return this.elements;
    }

}
