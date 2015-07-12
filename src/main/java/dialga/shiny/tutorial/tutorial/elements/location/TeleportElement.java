package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.EntityUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TeleportElement extends TutorialElement {

    private final String location;
    private final boolean smooth;

    /**
     * Teleport a player to a location.
     * @param delay The delay from the previous element.
     * @param location The relative location to teleport the player to.
     * @param smooth Wether the teleport should be smooth.
     */
    public TeleportElement(String delay, String location, boolean smooth) {
        super(delay);
        this.location = location;
        this.smooth = smooth;
    }

    @Override
    public final void perform(final Player viewer) {
        Location position = EntityUtils.newRelativeLocation(location, viewer);
        if (smooth) {
            Vector difference = position.toVector().subtract(viewer.getLocation().toVector());
            viewer.teleportRelative(difference, 0, 0);
        } else {
            viewer.teleport(position);
        }
    }

    public final Player getPlayer() {
        return this.getPlayer();
    }

    public final String getLocation() {
        return this.location;
    }

    public final boolean isSmooth() {
        return this.smooth;
    }

}
