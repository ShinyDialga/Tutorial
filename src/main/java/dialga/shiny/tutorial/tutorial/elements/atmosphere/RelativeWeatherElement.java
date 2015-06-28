package dialga.shiny.tutorial.tutorial.elements.atmosphere;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class RelativeWeatherElement extends StageElement {

    private final WeatherType weather;

    public RelativeWeatherElement(String delay, WeatherType weather) {
        super(delay);
        this.weather = weather;
    }

    @Override
    public void preform(Player viewer) {
        viewer.setPlayerWeather(weather);
    }

    public final WeatherType getWeather() {
        return this.weather;
    }
}
