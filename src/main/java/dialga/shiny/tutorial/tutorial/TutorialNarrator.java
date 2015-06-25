package dialga.shiny.tutorial.tutorial;

import org.bukkit.entity.EntityType;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class TutorialNarrator {

    private final Tutorial tutorial;
    private final String name;
    private final EntityType type;

    public TutorialNarrator(Tutorial tutorial, String name, EntityType type) {
        this.tutorial = tutorial;
        this.name = name;
        this.type = type;
    }

    public final Tutorial getTutorial() {
        return this.tutorial;
    }

    public final String getName() {
        return this.name;
    }

    public final EntityType getType() {
        return this.type;
    }

}
