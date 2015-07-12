package dialga.shiny.tutorial;

import dialga.shiny.tutorial.listener.ClientSideEntityTracker;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.listener.TutorialListener;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.tutorial.elements.effect.FireworkElement;
import dialga.shiny.tutorial.tutorial.elements.gamemode.GamemodeElement;
import dialga.shiny.tutorial.tutorial.elements.location.MovementElement;
import dialga.shiny.tutorial.tutorial.elements.location.TeleportElement;
import dialga.shiny.tutorial.tutorial.elements.message.ChatElement;
import dialga.shiny.tutorial.tutorial.elements.message.TitleElement;
import dialga.shiny.tutorial.tutorial.elements.interact.InteractElement;
import dialga.shiny.tutorial.impl.ExampleTutorial;
import dialga.shiny.tutorial.util.CommandUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialPlugin extends JavaPlugin {

    /** The tutorial plugin instance. */
    private static TutorialPlugin instance;
    /** Set of tutorials loaded for this plugin. */
    private Set<Tutorial> tutorials;
    /** The client side entity tracker for this plugin. */
    private ClientSideEntityTracker tracker;

    public void onEnable() {
        instance = this;
        tracker = new ClientSideEntityTracker();
        tutorials = new HashSet<Tutorial>();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new TutorialListener(), instance);
        manager.registerEvents(tracker, instance);
        CommandUtils.registerCommands();

        // DEBUG - Remove later.
        new ExampleTutorial();
    }

    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(instance);
        tracker.clear();
        tracker = null;
        tutorials = null;
    }

    /**
     * Get the plugin instance.
     * @return The plugin instance.
     */
    public static TutorialPlugin getInstance() {
        return instance;
    }

    /**
     * Get the plugin's client side entity tracker.
     * @return The client side entity tracker.
     */
    public ClientSideEntityTracker getTracker() {
        return this.tracker;
    }

    /**
     * Register a new tutorial.
     * @param tutorial The tutorial to register.
     */
    public void registerTutorial(Tutorial tutorial) {
        this.tutorials.add(tutorial);
    }

    /**
     * Unregister a tutorial.
     * @param tutorial The tutorial to unregister.
     */
    public void unregisterTutorial(Tutorial tutorial) {
        this.tutorials.remove(tutorial);
    }

    /**
     * Get the set of tutorials for this plugin.
     * @return The set of tutorials.
     */
    public Set<Tutorial> getTutorials() {
        return this.tutorials;
    }

    public void callEvent(Event event) {
        getServer().getPluginManager().callEvent(event);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return CommandUtils.onCommand(sender, cmd, commandLabel, args);
    }

}
