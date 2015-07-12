package dialga.shiny.tutorial.tutorial.elements.gamemode;

import dialga.shiny.tutorial.tutorial.elements.TutorialElement;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class GamemodeElement extends TutorialElement {

    private final GameMode gamemode;

    /**
     * Change the player's gamemode.
     * @param delay The delay from the previous element.
     * @param gamemode The new gamemode.
     */
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
