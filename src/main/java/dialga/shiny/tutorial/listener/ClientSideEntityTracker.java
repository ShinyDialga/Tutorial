package dialga.shiny.tutorial.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

/**
 * Created by ElectroidFilms on 6/29/2015.
 */
public class ClientSideEntityTracker implements Listener {

    private final Map<UUID, Set<Entity>> entityHideMap;

    /**
     * Creates a new ClientSideEntityTracker.
     *
     * This object takes normal bukkit entities and hides them
     * to all players but one player.
     */
    public ClientSideEntityTracker() {
        this.entityHideMap = new HashMap<UUID, Set<Entity>>();
    }

    /**
     * Schedule the entity to hidden from all other players except the viewer.
     * @param viewer The only player that can see the entity.
     * @param entity The entity that can only be seen by the viewer.
     */
    public void add(Player viewer, Entity entity) {
        /** Add the entity to the tracker map. */
        final UUID id = viewer.getUniqueId();
        Set<Entity> entities;
        if (entityHideMap.containsKey(id)) {
            entities = entityHideMap.get(id);
            entities.add(entity);
        } else {
            entities = new HashSet<Entity>();
            entities.add(entity);
        }
        entityHideMap.put(id, entities);
        /** Execute the client side transformation. */
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(viewer)) {
                viewer.hide(entity);
            }
        }
    }

    /**
     * Clear any client-side entities the given player can see.
     * @param viewer The player to remove their client-side entities.
     */
    public void remove(Player viewer) {
        final UUID id = viewer.getUniqueId();
        if (entityHideMap.containsKey(id)) {
            for (Entity entity : entityHideMap.get(id)) {
                entity.remove();
            }
        }
        entityHideMap.remove(id);
    }

    /**
     * Clear all client-side entities this tracker is monitoring.
     */
    public void clear() {
        for (Set<Entity> entities : entityHideMap.values()) {
            for (Entity entity : entities) {
                entity.remove();
            }
        }
        entityHideMap.clear();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        for (Map.Entry<UUID, Set<Entity>> entry : entityHideMap.entrySet()) {
            /** Hide any entities that don't belong to the player. */
            if (!entry.getKey().equals(event.getPlayer().getUniqueId())) {
                for (Entity entity : entry.getValue()) {
                    event.getPlayer().hide(entity);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent event) {
        UUID id = event.getPlayer().getUniqueId();
        if (entityHideMap.containsKey(id)) {
            for (Entity entity : entityHideMap.get(id)) {
                entity.remove();
            }
        }
    }

}
