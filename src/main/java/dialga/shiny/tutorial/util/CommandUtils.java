package dialga.shiny.tutorial.util;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import com.sk89q.minecraft.util.commands.CommandException;
import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.command.TutorialCommand;
import org.bukkit.command.*;

/**
 * Created by ShinyDialga45 on 3/21/15.
 */
public class CommandUtils {

    private static CommandsManager<CommandSender> commands;
    private static CommandsManagerRegistration cmdRegister;

    public static void registerCommands() {
        commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String perm) {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
            }
        };
        cmdRegister = new CommandsManagerRegistration(TutorialPlugin.getInstance(), commands);
        cmdRegister.register(TutorialCommand.class);
    }

    public static void unregisterCommands() {
        commands = null;
        cmdRegister.unregisterCommands();
        cmdRegister = null;
    }

    public static boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
        try {
            commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {
            sender.sendMessage(org.bukkit.ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(org.bukkit.ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(org.bukkit.ChatColor.RED + e.getMessage());
            sender.sendMessage(org.bukkit.ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            if (e.getCause() instanceof NumberFormatException) {
                sender.sendMessage(org.bukkit.ChatColor.RED + "Number expected, string received instead.");
            } else {
                sender.sendMessage(org.bukkit.ChatColor.RED + "An error has occurred.");
                e.printStackTrace();
            }
        } catch (CommandException e) {
            sender.sendMessage(org.bukkit.ChatColor.RED + e.getMessage());
        }
        return true;
    }

}
