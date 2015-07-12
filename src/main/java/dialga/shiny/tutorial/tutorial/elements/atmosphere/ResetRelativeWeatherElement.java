package dialga.shiny.tutorial.tutorial.elements.atmosphere;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class ResetRelativeWeatherElement extends TutorialElement {

    public ResetRelativeWeatherElement(String delay) {
        super(delay);
    }

    @Override
    public void perform(Player viewer) {
        viewer.resetPlayerWeather();
    }

}
