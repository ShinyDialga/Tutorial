package dialga.shiny.tutorial.tutorial.elements.particle;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class ParticleElement extends StageElement {

    private final Effect effect;
    private final Location location;

    public ParticleElement(final Effect effect, final Location location, final int delay) {
        super(delay);
        this.effect = effect;
        this.location = location;
    }

    public final Effect getEffect() {
        return this.effect;
    }

    public final Location getLocation() {
        return this.location;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        watcher.playEffect(location, effect, new Integer(5));
    }

}
