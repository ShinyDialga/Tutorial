package dialga.shiny.tutorial.tutorial.elements.firework;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftFirework;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class FireworkElement extends StageElement {

    private final FireworkEffect.Type type;
    private final Color color;
    private final Color fade;

    public FireworkElement(final FireworkEffect.Type type, final Color color, Color fade, final int delay) {
        super(delay);
        this.type = type;
        this.color = color;
        this.fade = fade;
    }

    public final FireworkEffect.Type getType() {
        return this.type;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Color getFade() {
        return this.fade;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        FireworkEffect effect = FireworkEffect.builder()
                .with(getType())
                .withColor(getColor())
                .withFade(getFade())
                .build();
        playFirework(watcher, effect);
    }

    private static void playFirework(Player watcher, FireworkEffect effect) {
        Location location = watcher.getLocation();
        location.setY(location.getY() - 1);
        final Firework firework = watcher.getLocation().getWorld().spawn(location, Firework.class);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != watcher) {
                player.hide(firework);
            }
        }
        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(effect);
        firework.setFireworkMeta(meta);
        NBTTagCompound nbtData = new NBTTagCompound();
        nbtData.setInt("Life", 0);
        nbtData.setInt("LifeTime", 1);
        ((CraftFirework) firework).getHandle().a(nbtData);
    }

}
