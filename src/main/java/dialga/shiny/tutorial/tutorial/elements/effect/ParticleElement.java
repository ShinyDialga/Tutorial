package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class ParticleElement extends StageElement {

    private final Effect effect;
    private final Location location;
    private final int id;
    private final int data;
    private final float offX;
    private final float offY;
    private final float offZ;
    private final float speed;
    private final int count;
    private final int radius;

    public ParticleElement(String delay, Effect effect, Location location, Vector offset, int id, int data, float speed, int count, int radius) {
        super(delay);
        this.effect = effect;
        this.location = location;
        this.id = id;
        this.data = data;
        this.offX = (float) offset.getX();
        this.offY = (float) offset.getY();
        this.offZ = (float) offset.getZ();
        this.speed = speed;
        this.count = count;
        this.radius = radius;
    }

    @Override
    public final void perform(final Player viewer) {
        viewer.playEffect(location, effect, id, data, offX, offY, offZ, speed, count, radius);
    }

    public final Effect getEffect() {
        return this.effect;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final int getId() {
        return id;
    }

    public final int getData() {
        return data;
    }

    public final float getOffX() {
        return offX;
    }

    public final float getOffY() {
        return offY;
    }

    public final float getOffZ() {
        return offZ;
    }

    public final float getSpeed() {
        return speed;
    }

    public final int getCount() {
        return count;
    }

    public final int getRadius() {
        return radius;
    }
}
