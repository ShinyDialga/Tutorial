package dialga.shiny.tutorial.listener;

import dialga.shiny.tutorial.util.MetadataUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.InventoryHolder;

/**
 * Created by ShinyDialga45 on 6/26/2015.
 */
public class TutorialListener implements Listener {

    public static final String WALK_METADATA    = "tutorial-walk";
    public static final String OBSERVE_METADATA = "tutorial-interact";

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onLeave(PlayerQuitEvent event) {
        MetadataUtils.removeMetadata(event.getPlayer(), WALK_METADATA);
        MetadataUtils.removeMetadata(event.getPlayer(), OBSERVE_METADATA);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onKick(PlayerKickEvent event) {
        MetadataUtils.removeMetadata(event.getPlayer(), WALK_METADATA);
        MetadataUtils.removeMetadata(event.getPlayer(), OBSERVE_METADATA);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), WALK_METADATA)) {
            Location from = event.getFrom();
            Location to = event.getTo();
            if (from.getX() != to.getX() ||
                    from.getY() != to.getY() ||
                    from.getZ() != to.getZ()) {
                event.setTo(event.getFrom());
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            if (event.hasBlock() && event.getClickedBlock() instanceof InventoryHolder) {
                event.getPlayer().openInventory(((InventoryHolder) event.getClickedBlock()).getInventory());
            }
            event.setUseInteractedBlock(Event.Result.DENY);
        }
    }


    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        if (event.getEntity() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getEntity(), OBSERVE_METADATA)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractAtEntityEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getDamager(), OBSERVE_METADATA)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getAttacker() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getAttacker(), OBSERVE_METADATA)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        if (event.getAttacker() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getAttacker(), OBSERVE_METADATA)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (MetadataUtils.hasMetadata(event.getPlayer(), OBSERVE_METADATA)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        if (event.getEntity() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getEntity(), OBSERVE_METADATA)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            if (MetadataUtils.hasMetadata(event.getWhoClicked(), OBSERVE_METADATA)) {
                if (event.getInventory() != event.getWhoClicked().getInventory()) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
