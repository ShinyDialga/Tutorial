package dialga.shiny.tutorial.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialCommand {

    @Command(aliases = {"tutorial"}, desc = "Tutorial plugin base command")
    public static void tutorial(final CommandContext args, CommandSender sender) throws Exception {
        Player player = (Player) sender;
    }

}
