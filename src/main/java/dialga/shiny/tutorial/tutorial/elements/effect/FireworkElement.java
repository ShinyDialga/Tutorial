package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.SpawnUtils;
import dialga.shiny.tutorial.util.TimeUnit;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftFirework;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class FireworkElement extends StageElement {

    private final Location location;
    private final FireworkEffect.Type type;
    private final Color[] colors;
    private final Color[] fades;
    private final boolean trail;
    private final boolean flicker;
    private final int lifeTicks;
    private final int lifetimeTicks;

    public FireworkElement(String delay, Location location, FireworkEffect.Type type, Color[] colors, Color[] fades, boolean trail, boolean flicker, String life, String lifetime) {
        super(delay);
        this.location = location;
        this.type = type;
        this.colors = colors;
        this.fades = fades;
        this.trail = trail;
        this.flicker = flicker;
        this.lifeTicks = TimeUnit.toTicks(life);
        this.lifetimeTicks = TimeUnit.toTicks(lifetime);
    }

    @Override
    public final void preform(final Player viewer) {
        Firework firework = (Firework) SpawnUtils.spawnViewerSpecificEntity(viewer, location, Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder()
                .flicker(flicker)
                .trail(trail)
                .with(type)
                .withColor(colors)
                .withFade(fades)
                .build();
        meta.addEffect(effect);
        firework.setFireworkMeta(meta);
        NBTTagCompound nbtData = new NBTTagCompound();
        nbtData.setInt("Life", lifeTicks);
        nbtData.setInt("LifeTime", lifetimeTicks);
        ((CraftFirework) firework).getHandle().a(nbtData);
    }

    public final Location getLocation() {
        return this.location;
    }

    public final FireworkEffect.Type getType() {
        return this.type;
    }

    public final Color[] getColors() {
        return this.colors;
    }

    public final Color[] getFades() {
        return this.fades;
    }

    public final boolean hasTrail() {
        return this.trail;
    }

    public final boolean hasFlicker() {
        return this.flicker;
    }

    public final int getLife() {
        return this.lifeTicks;
    }

    public final int getLifetime() {
        return this.lifetimeTicks;
    }

}
