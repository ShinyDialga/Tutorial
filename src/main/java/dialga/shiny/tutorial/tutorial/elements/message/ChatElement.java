package dialga.shiny.tutorial.tutorial.elements.message;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/2015.
 */
public class ChatElement extends StageElement {

    private final String message;

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
