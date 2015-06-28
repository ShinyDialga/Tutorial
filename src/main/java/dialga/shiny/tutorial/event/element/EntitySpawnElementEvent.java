package dialga.shiny.tutorial.event.element;

import dialga.shiny.tutorial.event.ElementEvent;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.tutorial.elements.entity.EntitySpawnElement;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class EntitySpawnElementEvent extends ElementEvent implements Cancellable {

    private final EntitySpawnElement element;
    private final Tutorial tutorial;
    private final Player viewer;
    private Entity entity;

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    /**
     * Creates an EnitySpawnElementEvent.
     * @param entity The entity to spawn.
     * @param element The element in the tutorial.
     * @param tutorial The tutorial currently running.
     * @param viewer The viewer watching the tutorial and seeing the entity.
     */
    public EntitySpawnElementEvent(Entity entity, EntitySpawnElement element, Tutorial tutorial, Player viewer) {
        this.entity = entity;
        this.element = element;
        this.tutorial = tutorial;
        this.viewer = viewer;
    }

    /**
     * Get the entity that spawned. (Note: this is mutable)
     * @return The entity that spawned.
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Replace the entity to be spawned.
     * @param entity The new entity to spawn.
     */
    public void setEntity(Entity entity) {
        Location location = this.entity.getLocation();
        this.entity.remove();
        entity.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    public EntitySpawnElement getElement() {
        return this.element;
    }

    /**
     * Gets the tutorial and all of its sub-elements and other parameters.
     * @return The tutorial that just started.
     */
    @Override
    public Tutorial getTutorial() {
        return this.tutorial;
    }

    /**
     * Gets the viewer of the tutorial.
     * @return The viewer of the tutorial.
     */
    @Override
    public Player getViewer() {
        return this.viewer;
    }

    /**
     * Get whether the event has been cancelled.
     * @return Whether the event is cancelled.
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Set the event to be cancelled or not.
     * @param cancelled Whether the event will be cancelled.
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Get the handler list for the event.
     * @return The handler list.
     */
    @Override
    public HandlerList getHandlers() {
        return EntitySpawnElementEvent.handlers;
    }

}
