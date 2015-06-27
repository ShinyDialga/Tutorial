package dialga.shiny.tutorial.tutorial.elements.message;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class MessageElement extends StageElement {

    private final MessageScope scope;
    private final String message;

    public MessageElement(final MessageScope scope, final String message, final int delay) {
        super(delay);
        this.scope = scope;
        this.message = message;
    }

    public final MessageScope getScope() {
        return this.scope;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        switch (getScope()) {
            case CHAT:
                watcher.sendMessage(getMessage());
            case TITLE:
                watcher.showTitle(new TextComponent(getMessage()));
        }
    }
}
