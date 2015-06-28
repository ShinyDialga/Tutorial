package dialga.shiny.tutorial.tutorial.elements.entity;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.SpawnUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class EntitySpawnElement extends StageElement {

    private final Class<? extends org.bukkit.entity.Entity> clazz;
    private final Vector velocity;
    private final Location location;

    @Override
    public final void preform(final Player viewer) {
        org.bukkit.entity.Entity entity = SpawnUtils.spawnViewerSpecificEntity(viewer, location, clazz);
        entity.setVelocity(getVelocity());
    }

    public EntitySpawnElement(String delay, Class<? extends org.bukkit.entity.Entity> clazz, Location location, Vector velocity) {
        super(delay);
        this.clazz = clazz;
        this.velocity = velocity;
        this.location = location;
    }

    public final Class<? extends org.bukkit.entity.Entity> getType() {
        return this.clazz;
    }

    public final Vector getVelocity() {
        return this.velocity;
    }

    public final Location getLocation() {
        return this.location;
    }

}
