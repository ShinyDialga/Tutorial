package dialga.shiny.tutorial.tutorial;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

/**
 * Created by ShinyDialga45 on 6/26/2015.
 */
public class TutorialListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-walk")) {
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
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            if (event.getClickedBlock() == null || event.getClickedBlock().getType().equals(Material.AIR)) {
                if (event.getItem() != null && !event.getItem().getType().equals(Material.COMPASS) && !event.getItem().getType().equals(Material.WRITTEN_BOOK)) {
                    event.setCancelled(true);
                }
            } else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock().getType().equals(Material.CHEST)) {
                Chest chest = (Chest) event.getClickedBlock().getState();
                event.getPlayer().openInventory(chest.getInventory());
                event.setCancelled(true);
            }
            try {
                if (!event.getItem().getType().equals(Material.COMPASS)) {
                    event.setCancelled(true);
                }
            } catch (Exception e) {

            }
            event.setUseInteractedBlock(Event.Result.DENY);
        }
    }


    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        if (event.getEntity().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractAtEntityEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getAttacker().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        if (event.getAttacker().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (event.getPlayer().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        if (event.getEntity().hasMetadata("tutorial-observe")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryClickEvent event) {
        if (event.getWhoClicked().hasMetadata("tutorial-observe")) {
            if (event.getInventory() != event.getWhoClicked().getInventory()) {
                event.setCancelled(true);
            }
        }
    }

}
