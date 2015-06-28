package dialga.shiny.tutorial.tutorial.elements.location;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class WalkElement extends StageElement {

    private final Entity entity;
    private final Location location;

    public WalkElement(String delay, Entity entity, Location location) {
        super(delay);
        this.entity = entity;
        this.location = location;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final Location getLocation() {
        return this.location;
    }

    @Override
    public final void preform(final Player viewer) {
        //TODO - Make getEntity() walk to getLocation()
    }

}
