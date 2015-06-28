package dialga.shiny.tutorial.tutorial.elements.gamemode;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class GamemodeElement extends StageElement {

    private final GameMode gamemode;

    public GamemodeElement(String delay, GameMode gamemode) {
        super(delay);
        this.gamemode = gamemode;
    }

    @Override
    public final void perform(final Player viewer) {
        viewer.setGameMode(getGamemode());
    }

    public final GameMode getGamemode() {
        return this.gamemode;
    }

}
