package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.listener.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class MovementElement extends TutorialElement {

    private final boolean canMove;

    /**
     * Change whether the player can move.
     * @param delay The delay from the previous element.
     * @param canMove Whether the player can move.
     */
    public MovementElement(String delay, boolean canMove) {
        super(delay);
        this.canMove = canMove;
    }

    @Override
    public final void perform(final Player viewer) {
        if (canWalk()) {
            MetadataUtils.removeMetadata(viewer, TutorialListener.WALK_METADATA);
        } else {
            MetadataUtils.addMetadata(viewer, TutorialListener.WALK_METADATA, canMove);
        }
    }

    public final boolean canWalk() {
        return this.canMove;
    }

}
