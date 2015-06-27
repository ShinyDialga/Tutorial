package dialga.shiny.tutorial.tutorial.elements.entity;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class EntityElement extends StageElement {

    private final EntityType entityType;
    private final Vector velocity;
    private final Location location;

    public EntityElement(final EntityType entityType, final Vector velocity, final Location location, final int delay) {
        super(delay);
        this.entityType = entityType;
        this.velocity = velocity;
        this.location = location;
    }

    public final EntityType getType() {
        return this.entityType;
    }

    public final Vector getVelocity() {
        return this.velocity;
    }

    public final Location getLocation() {
        return this.location;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        Entity entity = watcher.getLocation().getWorld().spawn(getLocation(), getType().getEntityClass());
        entity.setVelocity(getVelocity());
    }

}
