package dialga.shiny.tutorial.util;

import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class ReflectionUtils {


    /**
     * Get the nms class given the package path.
     * @param packagePath The package path to query.
     * @return The nms class that matched the package path.
     */
    public static Class<?> getNmsClass(String packagePath) {
        return getVersionClass("net.minecraft.server.%s." + packagePath);
    }

    /**
     * Get the craftbukkit class given the package path.
     * @param packagePath The package path to query.
     * @return The craftbukkit class that matched the package path.
     */
    public static Class<?> getCraftClass(String packagePath) {
        return getVersionClass("org.bukkit.craftbukkit.%s." + packagePath);
    }

    /** Internal method to get class for both nms and craftbukkit. */
    private static Class<?> getVersionClass(String clazz) {
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

    /**
     * Create a raw NMS NBTTagCompound.
     * @param keyToValueMap The keys mapped to their values.
     * @return The new NBtTagCompound as an object.
     */
    public static Object createRawNbt(Map<String, Object> keyToValueMap) {
        try {
            // bool, byte, byte[], double, float, int, int[], long, short, string,
            Class clazz = getNmsClass("NBTTagCompound");
            Object tag = clazz.newInstance();
            /** Iterate through each value and find the matching declared method to add the nbt data. */
            for (Map.Entry<String, Object> entry : keyToValueMap.entrySet()) {
                String className = entry.getValue().getClass().getSimpleName();
                Method method = null;
                if (className.equals("boolean")) {
                    method = clazz.getDeclaredMethod("setBoolean",   String.class, boolean.class);
                } else if (className.equalsIgnoreCase("byte")) {
                    method = clazz.getDeclaredMethod("setByte",      String.class, byte.class);
                } else if (className.equalsIgnoreCase("byte[]")) {
                    method = clazz.getDeclaredMethod("setByteArray", String.class, byte[].class);
                } else if (className.equalsIgnoreCase("double")) {
                    method = clazz.getDeclaredMethod("setDouble",    String.class, double.class);
                } else if (className.equalsIgnoreCase("long")) {
                    method = clazz.getDeclaredMethod("setLong",      String.class, long.class);
                } else if (className.equals("int") || className.equals("Integer")) {
                    method = clazz.getDeclaredMethod("setInt",       String.class, int.class);
                } else if (className.equals("int[]") || className.equals("Integer[]")) {
                    method = clazz.getDeclaredMethod("setIntArray",  String.class, int[].class);
                } else if (className.equalsIgnoreCase("short")) {
                    method = clazz.getDeclaredMethod("setShort",     String.class, short.class);
                } else if (className.equalsIgnoreCase("float")) {
                    method = clazz.getDeclaredMethod("setFloat",     String.class, float.class);
                } else if (className.equals("String")) {
                    method = clazz.getDeclaredMethod("setString",    String.class, String.class);
                }
                if (method != null) {
                    method.invoke(tag, entry.getKey(), entry.getValue());
                }
            }
            return tag;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Send a packet to a player.
     * @param player The player to send the packet to.
     * @param packet The packet object.
     */
    public static void sendPacket(Player player, Object packet) {
        try {
            /** Get all classes required for reflection. */
            Class craftPlayerClass =      getCraftClass("entity.CraftPlayer");
            Class handleClass =           getNmsClass  ("EntityPlayer");
            Class playerConnectionClass = getNmsClass  ("PlayerConnection");
            Class packetClass =           getNmsClass  ("Packet");
            /** Get the craft player object from the bukkit player. */
            Object craftPlayer = craftPlayerClass.cast(player);
            /** Get the handle from the craft player. */
            Method getHandle = craftPlayerClass.getDeclaredMethod("getHandle", new Class<?>[0]);
            Object handle = getHandle.invoke(craftPlayer, null);
            /** Get the player connection tunnel from the handle. */
            Field playerConnectionField = handleClass.getField("playerConnection");
            Object playerConnection = playerConnectionField.get(handle);
            /** Send the packet through the player connection tunnel. */
            Method sendPacket = playerConnectionClass.getDeclaredMethod("sendPacket", packetClass);
            sendPacket.invoke(playerConnection, packet);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
