package dialga.shiny.tutorial.tutorial.elements.message;

import dialga.shiny.tutorial.tutorial.elements.StageElement;
import dialga.shiny.tutorial.util.TimeUnit;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by ElectroidFilms on 6/27/2015.
 */
public class TitleElement extends StageElement {

    private final String title;
    private final String subTitle;
    private final int fadeInTicks;
    private final int stayTicks;
    private final int fadeOutTicks;

    public TitleElement(String delay, String title, String subTitle, String fadeIn, String stay, String fadeOut) {
        super(delay);
        this.title = title;
        this.subTitle = subTitle;
        this.fadeInTicks = TimeUnit.toTicks(fadeIn);
        this.stayTicks = TimeUnit.toTicks(stay);
        this.fadeOutTicks = TimeUnit.toTicks(fadeOut);
    }

    @Override
    public final void perform(final Player viewer) {
        viewer.showTitle(TextComponent.fromLegacyText(title), TextComponent.fromLegacyText(subTitle), fadeInTicks, stayTicks, fadeOutTicks);
    }

    public final String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getFadeInTicks() {
        return fadeInTicks;
    }

    public int getStayTicks() {
        return stayTicks;
    }

    public int getFadeOutTicks() {
        return fadeOutTicks;
    }

}
