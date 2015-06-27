package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class MovementElement extends StageElement {

    private final boolean canWalk;

    public MovementElement(final boolean canWalk, final int delay) {
        super(delay);
        this.canWalk = canWalk;
    }

    public final boolean getCanWalk() {
        return this.canWalk;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        if (getCanWalk()) {
            watcher.removeMetadata("tutorial-walk", TutorialPlugin.getInstance());
        } else {
            watcher.setMetadata("tutorial-walk", new FixedMetadataValue(TutorialPlugin.getInstance(), getCanWalk()));
        }
    }

}
