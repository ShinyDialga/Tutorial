package dialga.shiny.tutorial.tutorial;

import dialga.shiny.tutorial.TutorialPlugin;
import dialga.shiny.tutorial.tutorial.stages.Stage;
import dialga.shiny.tutorial.tutorial.stages.elements.StageElement;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public class Tutorial {

    private final List<Stage> stages;

    public Tutorial(final List<Stage> stages) {
        this.stages = stages;
    }

    public final List<Stage> getStages() {
        return this.stages;
    }

    public final Stage getNextStage(final Stage stage) {
        final int stageIndex = getStages().indexOf(stage);
        try {
            return getStages().get(stageIndex + 1) != null ? getStages().get(stageIndex + 1) : stage;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public final void playTutorial(final Player player) {
        final Stage firstStage = getStages().get(0);
        playStage(player, firstStage);
    }

    private final void playStage(final Player player, final Stage stage) {
        if (stage != null) {
            for (final StageElement element : stage.getElements()) {
                TutorialPlugin.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
                    public void run() {
                        element.onElementPerform(player);
                    }
                }, element.getDelay());
            }
            TutorialPlugin.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(TutorialPlugin.getInstance(), new Runnable() {
                public void run() {
                    playStage(player, getNextStage(stage));
                }
            }, stage.getDuration());
        }
    }

}
