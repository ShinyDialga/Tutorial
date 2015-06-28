package dialga.shiny.tutorial.event.tutorial;

import dialga.shiny.tutorial.event.TutorialEvent;
import dialga.shiny.tutorial.tutorial.Tutorial;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class TutorialFinishEvent extends TutorialEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Tutorial tutorial;
    private final Player viewer;
    private boolean cancelled = false;

    /**
     * Creates a new TutorialFinishEvent.
     * @param tutorial The tutorial that finished.
     * @param viewer The viewer that is watching the tutorial.
     */
    public TutorialFinishEvent(final Tutorial tutorial, final Player viewer) {
        this.tutorial = tutorial;
        this.viewer = viewer;
    }

    /**
     * Gets the tutorial and all of its sub-elements and other parameters.
     * @return The tutorial that just started.
     */
    @Override
    public Tutorial getTutorial() {
        return this.tutorial;
    }

    /**
     * Gets the viewer of the tutorial.
     * @return The viewer of the tutorial.
     */
    @Override
    public Player getViewer() {
        return this.viewer;
    }

    /**
     * Get the handler list for the event.
     * @return The handler list.
     */
    @Override
    public HandlerList getHandlers() {
        return TutorialFinishEvent.handlers;
    }
    
}
