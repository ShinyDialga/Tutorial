package dialga.shiny.tutorial.tutorial.elements.sound;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Note;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/2015.
 */
public class NoteElement extends StageElement {

    private final Instrument instrument;
    private final Note note;
    private final Location location;

    public NoteElement(String delay, Instrument instrument, Note note, Location location) {
        super(delay);
        this.instrument = instrument;
        this.note = note;
        this.location = location;
    }

    public final Instrument getInstrument() {
        return this.instrument;
    }

    public final Note getNote() {
        return this.note;
    }

    public final Location getLocation() {
        return this.location;
    }

    @Override
    public final void preform(final Player viewer) {
        viewer.playNote(location, instrument, note);
    }

}
