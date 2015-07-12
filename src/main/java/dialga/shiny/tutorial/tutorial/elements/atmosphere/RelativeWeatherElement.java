package dialga.shiny.tutorial.tutorial.elements.atmosphere;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class RelativeWeatherElement extends TutorialElement {

    private final WeatherType weather;

    public RelativeWeatherElement(String delay, WeatherType weather) {
        super(delay);
        this.weather = weather;
    }

    @Override
    public void perform(Player viewer) {
        viewer.setPlayerWeather(weather);
    }

    public final WeatherType getWeather() {
        return this.weather;
    }
}
