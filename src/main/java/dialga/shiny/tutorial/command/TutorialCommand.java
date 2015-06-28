package dialga.shiny.tutorial.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.tutorial.elements.atmosphere.RelativeTimeElement;
import dialga.shiny.tutorial.tutorial.elements.atmosphere.RelativeWeatherElement;
import dialga.shiny.tutorial.tutorial.elements.atmosphere.ResetRelativeTimeElement;
import dialga.shiny.tutorial.tutorial.elements.atmosphere.ResetRelativeWeatherElement;
import dialga.shiny.tutorial.tutorial.elements.effect.ExplosionElement;
import dialga.shiny.tutorial.tutorial.elements.effect.FireworkElement;
import dialga.shiny.tutorial.tutorial.elements.effect.ParticleElement;
import dialga.shiny.tutorial.tutorial.elements.entity.EntitySpawnElement;
import dialga.shiny.tutorial.tutorial.elements.location.MovementElement;
import dialga.shiny.tutorial.tutorial.elements.location.TeleportElement;
import dialga.shiny.tutorial.tutorial.elements.message.ChatElement;
import dialga.shiny.tutorial.tutorial.elements.message.TitleElement;
import dialga.shiny.tutorial.tutorial.elements.observe.ObserverElement;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialCommand {

    @Command(aliases = {"tutorial"}, desc = "Tutorial plugin base command")
    public static void tutorial(final CommandContext args, CommandSender sender) throws Exception {
        Player player = (Player) sender;
        List<StageElement> elements = new ArrayList<StageElement>();
        elements.add(new ObserverElement            ("0s", true));
        elements.add(new MovementElement            ("0s", false));
        elements.add(new ChatElement                ("0s", ChatColor.RED + "Hello!"));
        elements.add(new TeleportElement            ("0s", player, new Location(player.getWorld(), 922.5, 64, 138.5)));
        elements.add(new FireworkElement            ("5s", new Location(player.getWorld(), 922.5, 64, 138.5), FireworkEffect.Type.CREEPER, new Color[] {Color.AQUA, Color.BLACK},  new Color[] {Color.AQUA, Color.BLACK}, true, true, "0t", "1t"));
        elements.add(new EntitySpawnElement         ("5", TNTPrimed.class, new Location(player.getWorld(), 939.5, 68, 135.5), new Vector(0, 0.1, 0.1)));
        elements.add(new TitleElement               ("5s", ChatColor.AQUA + "Title", ChatColor.BOLD + "Subtitle", "1t", "2s", "1s"));
        elements.add(new ExplosionElement           ("7s", new Location(player.getWorld(), 939.5, 68, 135.5), (float) 5));
        elements.add(new ParticleElement            ("2s", Effect.HAPPY_VILLAGER, player.getTargetedBlock(false, false).getPosition().toLocation(player.getWorld()), new Vector(0,0,0), 1, 1, 1, 10, 30));
        elements.add(new RelativeTimeElement        ("4s", 1800L));
        elements.add(new RelativeWeatherElement     ("3s", WeatherType.DOWNFALL));
        elements.add(new ResetRelativeWeatherElement("5s"));
        elements.add(new TitleElement               ("0s", ChatColor.AQUA + "The weather shall go away!!!", "", "1s", "3s", "1s"));
        elements.add(new ResetRelativeTimeElement   ("0s"));
        Tutorial tutorial = new Tutorial            ("Test Tutorial", elements);
        tutorial.playTutorial(player);
    }

}
