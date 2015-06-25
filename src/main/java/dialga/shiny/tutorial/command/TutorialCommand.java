package dialga.shiny.tutorial.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.tutorial.stages.Stage;
import dialga.shiny.tutorial.tutorial.stages.elements.StageElement;
import dialga.shiny.tutorial.tutorial.stages.elements.location.TeleportElement;
import dialga.shiny.tutorial.tutorial.stages.elements.message.MessageElement;
import dialga.shiny.tutorial.tutorial.stages.elements.message.MessageScope;
import dialga.shiny.tutorial.tutorial.stages.elements.particle.ParticleElement;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialCommand {

    @Command(aliases = {"tutorial"}, desc = "Tutorial plugin base command")
    public static void tutorial(final CommandContext args, CommandSender sender) throws Exception {
        Player player = (Player) sender;
        List<StageElement> elements = new ArrayList<>();
        elements.add(new TeleportElement(player, new Location(player.getWorld(), 0, 5, 0), 5));
        elements.add(new ParticleElement(Effect.SMOKE, new Location(player.getWorld(), 0, 5, 0), 6));
        elements.add(new MessageElement(MessageScope.CHAT, "This is a test command!", 10));
        List<Stage> stages = Arrays.asList(new Stage(elements, 50));
        Tutorial tutorial = new Tutorial(stages);
        tutorial.playTutorial(player);
    }

}
