package dialga.shiny.tutorial.tutorial.elements.entity;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.event.element.EntitySpawnElementEvent;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.EntityUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class EntitySpawnElement extends TutorialElement {

    private final Class<? extends Entity> clazz;
    private final Vector velocity;
    private final String location;

    /**
     * Spawn a new entity at a location.
     * @param delay The delay from the previous element.
     * @param clazz The class of the entity.
     * @param location The relative location of the entity.
     * @param velocity The velocity of the entity when it spawns.
     */
    public EntitySpawnElement(String delay, Class<? extends Entity> clazz, String location, Vector velocity) {
        super(delay);
        this.clazz = clazz;
        this.velocity = velocity;
        this.location = location;
    }

    @Override
    public final void perform(final Player viewer) {
        Entity entity = EntityUtils.spawnViewerSpecificEntity(viewer, EntityUtils.newRelativeLocation(location, viewer), clazz);
        EntitySpawnElementEvent event = new EntitySpawnElementEvent(entity, this, null, viewer);
        TutorialPlugin.getInstance().callEvent(event);
        if (event.isCancelled()) {
            entity.remove();
        } else {
            entity.setVelocity(velocity);
        }
    }

    public final Class<? extends Entity> getType() {
        return this.clazz;
    }

    public final Vector getVelocity() {
        return this.velocity;
    }

    public final String getLocation() {
        return this.location;
    }

}
