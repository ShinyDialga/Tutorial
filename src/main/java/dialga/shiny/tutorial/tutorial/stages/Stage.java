package dialga.shiny.tutorial.tutorial.stages;

import dialga.shiny.tutorial.tutorial.stages.elements.StageElement;

import java.util.List;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class Stage {

    private final List<StageElement> elements;
    private final int duration;

    public Stage(final List<StageElement> elements, final int duration) {
        this.elements = elements;
        this.duration = duration;
    }

    public final List<StageElement> getElements() {
        return this.elements;
    }

    public final int getDuration() {
        return this.duration;
    }

}
