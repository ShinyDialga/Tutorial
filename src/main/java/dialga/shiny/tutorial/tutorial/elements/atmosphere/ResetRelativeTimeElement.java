package dialga.shiny.tutorial.tutorial.elements.atmosphere;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class ResetRelativeTimeElement extends TutorialElement {

    public ResetRelativeTimeElement(String delay) {
        super(delay);
    }

    @Override
    public void perform(Player viewer) {
        viewer.resetPlayerTime();
    }

}
