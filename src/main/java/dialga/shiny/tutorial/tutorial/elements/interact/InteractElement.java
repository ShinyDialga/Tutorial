package dialga.shiny.tutorial.tutorial.elements.interact;

import dialga.shiny.tutorial.listener.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class InteractElement extends TutorialElement {

    private final boolean canInteract;

    /**
     * Change whether a player can interact with the world.
     * @param delay The delay from the previous element.
     * @param canInteract Whether the player can interact with the world.
     */
    public InteractElement(String delay, boolean canInteract) {
        super(delay);
        this.canInteract = canInteract;
    }

    @Override
    public final void perform(final Player viewer) {
        if (canInteract) {
            MetadataUtils.removeMetadata(viewer, TutorialListener.OBSERVE_METADATA);
        } else {
            MetadataUtils.addMetadata(viewer, TutorialListener.OBSERVE_METADATA, canInteract);
        }
    }

    public final boolean canInteract() {
        return this.canInteract;
    }

}
