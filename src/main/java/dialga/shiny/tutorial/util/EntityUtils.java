package dialga.shiny.tutorial.util;

import dialga.shiny.tutorial.TutorialPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class EntityUtils {

    /** The pattern for matching relative vectors (ie. (1,1,1), (~0,10,-1), (~-1,32,-3)). */
    private static final String RELATIVE_VECTOR_REGEX = "(\\~([0-9]{1,}|-[0-9]{1,}|-)|\\~|([0-9]{1,}|-[0-9]{1,}|-))";

    /**
     * Create a new location object based on a relative-vector in string form. (ie. ~1,-42,23)
     * @param position The relative-vector in string form.
     * @param entity The entity for relative-vector and world reference
     * @return The new location given the entity's world and relative-vector.
     */
    public static Location newRelativeLocation(String position, Entity entity) {
        Matcher matcher = Pattern.compile(RELATIVE_VECTOR_REGEX, Pattern.CASE_INSENSITIVE).matcher(position);
        double[] vector = new double[3];
        for (int i = 0; i < 3 && matcher.find(); i++) {
            String number = matcher.group(0);
            if (number.contains("~")) {
                vector[i] = Double.parseDouble(entity.getLocation().toVector().serialize().values().toArray()[i].toString());
            }
            if (!number.replaceAll("~", "").trim().isEmpty()) {
                vector[i] += Double.parseDouble(number.replaceAll("~", ""));
            }
        }
        return new Location(entity.getWorld(), vector[0], vector[1], vector[2]);
    }

    /**
     * Spawn an entity that only the viewer is able to see.
     * @param viewer The viewer that can see the entity.
     * @param location The location of the entity.
     * @param clazz The class of the entity.
     * @return The entity object.
     */
    public static Entity spawnViewerSpecificEntity(Player viewer, Location location, Class<? extends Entity> clazz) {
        Entity entity = location.getWorld().spawn(location, clazz);
        convertToViewerSpecificEntity(viewer, entity);
        return entity;
    }

    /**
     * Convert an already existing entity to a viewer specific one.
     * @param viewer The viewer that can see the entity,
     * @param entity The entity that can only be seen by the viewer.
     */
    public static void convertToViewerSpecificEntity(Player viewer, Entity entity) {
        TutorialPlugin.getInstance().getTracker().add(viewer, entity);
    }

}
