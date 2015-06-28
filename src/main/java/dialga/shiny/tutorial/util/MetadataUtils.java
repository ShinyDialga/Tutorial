package dialga.shiny.tutorial.util;

import dialga.shiny.tutorial.TutorialPlugin;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by ElectroidFilms on 6/26/15.
 */
public class MetadataUtils {

    private final static JavaPlugin plugin = TutorialPlugin.getInstance();
    private static WeakHashMap<Metadatable, Set<String>> knownKeys = new WeakHashMap<Metadatable, Set<String>>();

    /**
     * Add a new FixedMetadataValue and add it to the metadatable.
     * @param metadatable The object to add the metadata to.
     * @param key The key of the metadata value.
     * @param value The object value mapped to the key.
     */
    public static void addMetadata(Metadatable metadatable, String key, Object value) {
        metadatable.setMetadata(key, new FixedMetadataValue(plugin, value));
        if (knownKeys.get(metadatable) == null) {
            Set<String> keys = new HashSet<String>();
            keys.add(key);
            knownKeys.put(metadatable, keys);
        } else if (!knownKeys.get(metadatable).contains(key)) {
            Set<String> keys = knownKeys.get(metadatable);
            keys.add(key);
            knownKeys.put(metadatable, keys);
        }
    }

    /**
     * Remove the FixedMetadataValue from the metadatable given the key.
     * @param metadatable The object to remove the metadata from.
     * @param key The key of the metadata value.
     */
    public static void removeMetadata(Metadatable metadatable, String key) {
        metadatable.removeMetadata(key, plugin);
        knownKeys.get(metadatable).remove(key);
    }

    /**
     * Get the FixedMetadataValue from the metadatable given the key.
     * @param metadatable The object to remove the metadata from.
     * @param key The key of the metadata value.
     * @return The object of the metadata value.
     */
    public static Object getMetadata(Metadatable metadatable, String key) {
        return metadatable.getMetadata(key, plugin);
    }

    /**
     * Get whether the metadatable has a value mapped to the given key.
     * @param metadatable The object to query the metadata from.
     * @param key The key of the potential metadata value.
     * @return Whether this metadatable has this metadata value.
     */
    public static boolean hasMetadata(Metadatable metadatable, String key) {
        return getMetadata(metadatable, key) != null ? true : false;
    }

}
