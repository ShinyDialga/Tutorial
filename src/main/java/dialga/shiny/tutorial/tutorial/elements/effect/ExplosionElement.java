package dialga.shiny.tutorial.tutorial.elements.effect;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
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
public class ExplosionElement extends StageElement {

    private final Location location;
    private final float power;

    public ExplosionElement(String delay, Location location, float power) {
        super(delay);
        this.location = location;
        this.power = power;
    }

    @Override
    public final void perform(final Player viewer) {
        try {
            Constructor constructor = ReflectionUtils.getNmsClass("PacketPlayOutExplosion")
                    .getConstructor(double.class, double.class, double.class, float.class, List.class, ReflectionUtils.getNmsClass("Vec3D"));
            ReflectionUtils.sendPacket(viewer, constructor.newInstance(location.getX(), location.getY(), location.getZ(), power, new ArrayList(), null));
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

    public final Location getLocation() {
        return this.location;
    }

    public final float getPower() {
        return this.power;
    }

}
