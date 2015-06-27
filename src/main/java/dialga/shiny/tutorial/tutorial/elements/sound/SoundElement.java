package dialga.shiny.tutorial.tutorial.elements.sound;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class SoundElement extends StageElement {

    private final String sound;

    public SoundElement(final String sound, final int delay) {
        super(delay);
        this.sound = sound;
    }

    public final String getSound() {
        return this.sound;
    }

    @Override
    public void onElementPerform(final Player watcher) {
        watcher.playSound(watcher.getLocation(), getSound(), 5, 5);
    }

}
