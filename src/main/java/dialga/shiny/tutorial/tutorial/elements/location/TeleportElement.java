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

    public TeleportElement(String delay, Entity entity, Location location) {
        super(delay);
        this.entity = entity;
        this.location = location;
    }

    @Override
    public final void perform(final Player viewer) {
        entity.teleport(location);
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final Location getLocation() {
        return this.location;
    }

}
