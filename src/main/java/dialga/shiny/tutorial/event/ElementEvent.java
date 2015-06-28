package dialga.shiny.tutorial.event;

import com.sun.org.apache.xml.internal.serialize.ElementState;
import dialga.shiny.tutorial.tutorial.Tutorial;
import dialga.shiny.tutorial.tutorial.elements.StageElement;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public abstract class ElementEvent extends TutorialEvent {

    public abstract StageElement getElement();

}
