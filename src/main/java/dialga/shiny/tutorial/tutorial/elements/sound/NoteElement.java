package dialga.shiny.tutorial.tutorial.elements.sound;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import dialga.shiny.tutorial.util.EntityUtils;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Note;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/2015.
 */
public class NoteElement extends TutorialElement {

    private final Instrument instrument;
    private final Note note;
    private final String location;

    /**
     * Play a note at a location.
     * @param delay The delay from the previous element.
     * @param instrument The instrument type.
     * @param note The note type.
     * @param location The relative location.
     */
    public NoteElement(String delay, Instrument instrument, Note note, String location) {
        super(delay);
        this.instrument = instrument;
        this.note = note;
        this.location = location;
    }

    @Override
    public final void perform(final Player viewer) {
        viewer.playNote(EntityUtils.newRelativeLocation(location, viewer), instrument, note);
    }

    public final Instrument getInstrument() {
        return this.instrument;
    }

    public final Note getNote() {
        return this.note;
    }

    public final String getLocation() {
        return this.location;
    }

}
