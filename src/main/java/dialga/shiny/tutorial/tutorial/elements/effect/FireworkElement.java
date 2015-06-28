package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.ReflectionUtils;
import dialga.shiny.tutorial.util.SpawnUtils;
import dialga.shiny.tutorial.util.TimeUnit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
    public final void perform(final Player viewer) {
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
        try {
            /** Load all the nbt values onto a map to proccess later. */
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("Life", lifeTicks);
            values.put("LifeTime", lifetimeTicks);
            /** Get all the nms/craftbukkit classes for reflection. */
            Class nbtClass = ReflectionUtils.getNmsClass("NBTTagCompound");
            Class craftFireworkClass = ReflectionUtils.getCraftClass("entity.CraftFirework");
            Class entityFireworksClass = ReflectionUtils.getNmsClass("EntityFireworks");
            /** Get the handle from the craft firework. */
            Object craftFirework = craftFireworkClass.cast(firework);
            Method getHandle = craftFireworkClass.getDeclaredMethod("getHandle", new Class<?>[0]);
            Object handle = getHandle.invoke(craftFirework, null);
            /** Add the nbt to the handle. */
            Method addNbt = entityFireworksClass.getDeclaredMethod("a", nbtClass);
            addNbt.invoke(handle, ReflectionUtils.createRawNbt(values));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            firework.detonate();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            firework.detonate();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            firework.detonate();
        }
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
