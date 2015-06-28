package dialga.shiny.tutorial.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.WeakHashMap;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class SpawnUtils {

    /**
     * Spawn an entity that only the viewer is able to see.
     * @param viewer The viewer that can see the entity.
     * @param location The location of the entity.
     * @param clazz The class of the entity.
     * @return The entity object.
     */
    public static Entity spawnViewerSpecificEntity(Player viewer, Location location, Class<? extends Entity> clazz) {
        final Entity entity = location.getWorld().spawn(location, clazz);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.equals(viewer))
                player.hide(entity);
        }
        class SpawnUtilsListener implements Listener {
            @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
            public void onJoin(PlayerJoinEvent event) {
                event.getPlayer().hide(entity);
            }
        }
        return entity;
    }



}
