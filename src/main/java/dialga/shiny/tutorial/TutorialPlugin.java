package dialga.shiny.tutorial;

import dialga.shiny.tutorial.utils.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialPlugin extends JavaPlugin {

    private static TutorialPlugin instance;

    public void onEnable() {
        instance = this;

        CommandUtils.registerCommands();
    }

    public static TutorialPlugin getInstance() {
        return instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return CommandUtils.onCommand(sender, cmd, commandLabel, args);
    }

    public void callEvent(Event event) {
        getInstance().getServer().getPluginManager().callEvent(event);
    }

}
