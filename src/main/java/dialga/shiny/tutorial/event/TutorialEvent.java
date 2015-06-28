package dialga.shiny.tutorial.event;

import dialga.shiny.tutorial.tutorial.Tutorial;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public abstract class TutorialEvent extends Event {

    public abstract Tutorial getTutorial();

    public abstract Player getViewer();

}
