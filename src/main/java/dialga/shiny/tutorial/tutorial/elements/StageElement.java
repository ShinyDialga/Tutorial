package dialga.shiny.tutorial.tutorial.elements;

import dialga.shiny.tutorial.util.TimeUnit;
import org.bukkit.entity.Player;

import java.sql.Time;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public abstract class StageElement {

    /** The delay from the previous element. */
    private final String delay;

    /**
     * Creates a new StageElement
     * @param delay The delay in ticks from the previous element.
     */
    public StageElement(String delay) {
        this.delay = delay;
    }

    /**
     * Get the delay in ticks from the previous stage.
     * @return The delay in ticks from the previous stage.
     */
    public final int getTickDelay() {
        return TimeUnit.toTicks(this.delay);
    }

    /**
     * Get the delay string from the previous stage.
     * @return The string delay from the previous stage.
     */
    public final String getStringDelay() {
        return this.delay;
    }

    /**
     * Show the stage element to a player.
     * @param viewer The player to show the stage element to.
     */
    public abstract void perform(final Player viewer);

}
