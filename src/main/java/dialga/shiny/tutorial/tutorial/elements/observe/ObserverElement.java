package dialga.shiny.tutorial.tutorial.elements.observe;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class ObserverElement extends StageElement {

    private final boolean isObserver;

    public ObserverElement(final boolean isObserver, final int delay) {
        super(delay);
        this.isObserver = isObserver;
    }

    public final boolean isObserver() {
        return this.isObserver;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        if (isObserver()) {
            watcher.setMetadata("tutorial-observe", new FixedMetadataValue(TutorialPlugin.getInstance(), isObserver()));
        } else {
            watcher.removeMetadata("tutorial-observe", TutorialPlugin.getInstance());
        }
    }

}
