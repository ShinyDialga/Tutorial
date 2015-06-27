package dialga.shiny.tutorial.tutorial;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class Tutorial {

    private final List<StageElement> elements;

    public Tutorial(final List<StageElement> elements) {
        this.elements = elements;
    }

    public final List<StageElement> getElements() {
        return this.elements;
    }

    public final void playTutorial(final Player player) {
        int delay = 0;
        for (final StageElement element : getElements()) {
            TutorialPlugin.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
                public void run() {
                    element.onElementPerform(player);
                }
            }, delay + element.getDelay());
            delay = delay + element.getDelay();
        }
    }
}
