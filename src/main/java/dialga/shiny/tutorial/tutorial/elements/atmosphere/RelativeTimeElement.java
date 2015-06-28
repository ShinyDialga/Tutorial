package dialga.shiny.tutorial.tutorial.elements.atmosphere;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.TimeUnit;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public class RelativeTimeElement extends StageElement {

    private final long time;

    public RelativeTimeElement(String delay, long time) {
        super(delay);
        this.time = time;
    }

    @Override
    public void preform(Player viewer) {
        viewer.setPlayerTime(time, true);
    }

    public final long getTime() {
        return this.time;
    }
}
