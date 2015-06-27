package dialga.shiny.tutorial.tutorial.elements;

import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public abstract class StageElement {

    private final int delay;

    public StageElement(int delay) {
        this.delay = delay;
    }

    public final int getDelay() {
        return this.delay;
    }

    public void onElementPerform(final Player watcher) {

    }

}
