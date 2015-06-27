package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TeleportElement extends StageElement {

    private final Entity entity;
    private final Location location;

    public TeleportElement(final Entity entity, final Location location, final int delay) {
        super(delay);
        this.entity = entity;
        this.location = location;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final Location getLocation() {
        return this.location;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        getEntity().teleport(getLocation());
    }

}
