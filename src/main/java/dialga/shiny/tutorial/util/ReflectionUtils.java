package dialga.shiny.tutorial.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class ReflectionUtils {

    // TODO - Finish this and remove any direct dependancy on nms imports.

    /**
     * Get the nms class using regex and iteration through all packages.
     * @param clazz The nms or craftbukkit class path. (ie. org.bukkit.craftbukkit.%v.entity.CraftArmorStand)
     * @return The class with the proper verion.
     */
    public static Class<?> getNmsClass(String clazz) {
        for (Package pack : Package.getPackages()) {
            Matcher regex = Pattern.compile("net\\.minecraft\\.(?:server)?\\.(v(?:\\d_)+R\\d)").matcher(pack.getName());
            if (regex.matches()) {
                try {
                    return Class.forName(String.format(clazz, regex.group(1)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
