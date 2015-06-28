package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class ExplosionElement extends StageElement {

    private final Location location;
    private final float power;

    public ExplosionElement(String delay, Location location, float power) {
        super(delay);
        this.location = location;
        this.power = power;
    }

    @Override
    public final void preform(final Player viewer) {
        ((CraftPlayer) viewer).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(location.getX(), location.getY(), location.getZ(), power, new ArrayList<BlockPosition>(), null));
    }

    public final Location getLocation() {
        return this.location;
    }

    public final float getPower() {
        return this.power;
    }

}
