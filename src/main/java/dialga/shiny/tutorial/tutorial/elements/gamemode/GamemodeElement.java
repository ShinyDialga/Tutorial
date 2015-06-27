package dialga.shiny.tutorial.tutorial.elements.gamemode;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class GamemodeElement extends StageElement {

    private final GameMode gameMode;

    public GamemodeElement(final GameMode gameMode, final int delay) {
        super(delay);
        this.gameMode = gameMode;
    }

    public final GameMode getGameMode() {
        return this.gameMode;
    }

    @Override
    public final void onElementPerform(final Player watcher) {
        watcher.setGameMode(getGameMode());
    }

}
