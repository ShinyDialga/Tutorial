package dialga.shiny.tutorial.tutorial.elements.observe;

import dialga.shiny.tutorial.tutorial.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class ObserverElement extends StageElement {

    private final boolean isObserver;

    public ObserverElement(String delay, boolean isObserver) {
        super(delay);
        this.isObserver = isObserver;
    }

    @Override
    public final void preform(final Player viewer) {
        if (isObserver) {
            MetadataUtils.addMetadata(viewer, TutorialListener.OBSERVE_METADATA, isObserver);
        } else {
            MetadataUtils.removeMetadata(viewer, TutorialListener.OBSERVE_METADATA);
        }
    }

    public final boolean isObserver() {
        return this.isObserver;
    }

}
