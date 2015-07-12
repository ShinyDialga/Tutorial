package dialga.shiny.tutorial.impl;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.tutorial.elements.effect.FireworkElement;
import dialga.shiny.tutorial.tutorial.elements.gamemode.GamemodeElement;
import dialga.shiny.tutorial.tutorial.elements.location.MovementElement;
import dialga.shiny.tutorial.tutorial.elements.location.TeleportElement;
import dialga.shiny.tutorial.tutorial.elements.message.ChatElement;
import dialga.shiny.tutorial.tutorial.elements.message.TitleElement;
import dialga.shiny.tutorial.tutorial.elements.interact.InteractElement;
import org.bukkit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ElectroidFilms on 7/9/15.
 */
public class ExampleTutorial extends Tutorial {

    public ExampleTutorial() {
        super("Example", null);
        List<TutorialElement> elements = new ArrayList<TutorialElement>();
        elements.add(new InteractElement("0s", true));
        elements.add(new MovementElement("0s", false));
        elements.add(new GamemodeElement("3s", GameMode.SPECTATOR));
        elements.add(new TitleElement   ("1s", ChatColor.AQUA + "Example", ChatColor.DARK_AQUA + "Tutorial", "10t", "2s", "10t"));
        elements.add(new TeleportElement("2s", "~,~5,~", false));
        elements.add(new ChatElement    ("0s", ChatColor.BOLD + "Teleported down 5 blocks!"));
        elements.add(new FireworkElement("1s", "~,~,~", FireworkEffect.Type.CREEPER, new Color[] {Color.BLUE}, new Color[] {Color.AQUA}, true, true, "5s", "5s"));
        elements.add(new GamemodeElement("0s", GameMode.CREATIVE));
        Tutorial tutorial = new Tutorial("Example", elements);
        TutorialPlugin.getInstance().registerTutorial(tutorial);
    }
}
