package dialga.shiny.tutorial.tutorial.elements.message;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/2015.
 */
public class ChatElement extends TutorialElement {

    private final String message;

    /**
     * Send a chat box message to a player (supports formatting).
     * @param delay The delay from the previous element.
     * @param message The chat message.
     */
    public ChatElement(String delay, String message) {
        super(delay);
        this.message = message;
    }

    @Override
    public final void perform(final Player viewer) {
        viewer.sendMessage(message);
    }

    public final String getMessage() {
        return this.message;
    }

}
