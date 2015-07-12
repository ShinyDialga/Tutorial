package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.EntityUtils;
import dialga.shiny.tutorial.util.ReflectionUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ElectroidFilms on 6/25/2015.
 */
public class ExplosionElement extends TutorialElement {

    private final String location;
    private final float power;

    /**
     * Spawn a new explosion at a location.
     * @param delay The delay from the previous element.
     * @param location The relative location where the explosion spawns.
     * @param power The power of the explosion.
     */
    public ExplosionElement(String delay, String location, float power) {
        super(delay);
        this.location = location;
        this.power = power;
    }

    @Override
    public final void perform(final Player viewer) {
        try {
            Location pos = EntityUtils.newRelativeLocation(location, viewer);
            Constructor constructor = ReflectionUtils.getNmsClass("PacketPlayOutExplosion")
                    .getConstructor(double.class, double.class, double.class, float.class, List.class, ReflectionUtils.getNmsClass("Vec3D"));
            ReflectionUtils.sendPacket(viewer, constructor.newInstance(pos.getX(), pos.getY(), pos.getZ(), power, new ArrayList(), null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final String getLocation() {
        return this.location;
    }

    public final float getPower() {
        return this.power;
    }

}
