package dialga.shiny.tutorial;

import dialga.shiny.tutorial.tutorial.TutorialListener;
import dialga.shiny.tutorial.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialPlugin extends JavaPlugin {

    private static TutorialPlugin instance;

    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new TutorialListener(), getInstance());

        CommandUtils.registerCommands();
    }

    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.removeMetadata("tutorial-walk", TutorialPlugin.getInstance());
            player.removeMetadata("tutorial-observe", TutorialPlugin.getInstance());
        }
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
