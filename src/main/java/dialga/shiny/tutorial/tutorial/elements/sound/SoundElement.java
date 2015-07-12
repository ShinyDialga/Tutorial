package dialga.shiny.tutorial.tutorial.elements.sound;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.EntityUtils;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class SoundElement extends TutorialElement {

    private final String location;
    private final String sound;
    private final float volume;
    private final float pitch;

    /**
     * Play a sound at a location.
     * @param delay The delay from the previous element.
     * @param location The relative location of the sound.
     * @param sound The sound file name (supports custom sounds in resource packs).
     * @param volume The volume of the sound.
     * @param pitch The pitch of the sound.
     */
    public SoundElement(String delay, String location, String sound, float volume, float pitch) {
        super(delay);
        this.location = location;
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    @Override
    public void perform(final Player viewer) {
        viewer.playSound(EntityUtils.newRelativeLocation(location, viewer), sound, volume, pitch);
    }

    public final String getLocation() {
        return this.location;
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
