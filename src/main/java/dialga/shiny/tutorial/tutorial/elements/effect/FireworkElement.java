package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.ReflectionUtils;
import dialga.shiny.tutorial.util.EntityUtils;
import dialga.shiny.tutorial.util.TimeUnit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class FireworkElement extends TutorialElement {

    private final String location;
    private final FireworkEffect.Type type;
    private final Color[] colors;
    private final Color[] fades;
    private final boolean trail;
    private final boolean flicker;
    private final int lifeTicks;
    private final int lifetimeTicks;

    /**
     * Spawn a new firework entity.
     * @param delay The delay from the previous elements.
     * @param location The relative location of the firework spawn.
     * @param type The type of firework effect.
     * @param colors The array of colors for this effect.
     * @param fades The array of colors that fade away for this effect.
     * @param trail Whether there is a trail.
     * @param flicker Whether the firework flickers.
     * @param life The life duration of the firework.
     * @param lifetime The entire lifetime of the firework.
     */
    public FireworkElement(String delay, String location, FireworkEffect.Type type, Color[] colors, Color[] fades, boolean trail, boolean flicker, String life, String lifetime) {
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
        Firework firework = (Firework) EntityUtils.spawnViewerSpecificEntity(viewer, EntityUtils.newRelativeLocation(location, viewer), Firework.class);
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
        Map<String, Object> nbt = new HashMap<String, Object>();
        nbt.put("Life", lifeTicks);
        nbt.put("LifeTime", lifetimeTicks);
        ReflectionUtils.applyNbt(firework, ReflectionUtils.createRawNbt(nbt));
    }

    public final String getLocation() {
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
