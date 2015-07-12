package dialga.shiny.tutorial.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.Tutorial;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;


/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialCommand {

    @Command(aliases = {"tutorial"}, desc = "Tutorial plugin base command")
    public static void tutorial(final CommandContext args, CommandSender sender) throws Exception {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.argsLength() >= 1) {
                Set<Tutorial> tutorials = TutorialPlugin.getInstance().getTutorials();
                if (tutorials.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "No tutorials are registred to view.");
                } else {
                    for (Tutorial tutorial : tutorials) {
                        if (tutorial.getName().equalsIgnoreCase(args.getRemainingString(0))) {
                            player.sendMessage(ChatColor.GREEN + "Playing tutorial.. " + tutorial.getName());
                            tutorial.play(player);
                            return;
                        }
                    }
                    player.sendMessage(ChatColor.RED + "Could not find tutorial named.. " + args.getRemainingString(0));
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only players may play a tutorial!");
        }


    }

}
