package dialga.shiny.tutorial.tutorial.elements.sound;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class SoundElement extends StageElement {

    private final String sound;
    private final float volume;
    private final float pitch;

    public SoundElement(String delay, String sound, float volume, float pitch) {
        super(delay);
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    @Override
    public void perform(final Player viewer) {
        viewer.playSound(viewer.getLocation(), sound, volume, pitch);
    }

    public final String getSound() {
        return this.sound;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

}
