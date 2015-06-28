package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.tutorial.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class MovementElement extends StageElement {

    private final boolean canWalk;

    public MovementElement(String delay, boolean canWalk) {
        super(delay);
        this.canWalk = canWalk;
    }

    @Override
    public final void perform(final Player viewer) {
        if (canWalk()) {
            MetadataUtils.removeMetadata(viewer, TutorialListener.WALK_METADATA);
        } else {
            MetadataUtils.addMetadata(viewer, TutorialListener.WALK_METADATA, canWalk);
        }
    }

    public final boolean canWalk() {
        return this.canWalk;
    }

}
