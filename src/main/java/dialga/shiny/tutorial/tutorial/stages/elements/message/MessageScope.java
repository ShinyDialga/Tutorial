package dialga.shiny.tutorial.tutorial.stages.elements.message;

/**
 * Created by ShinyDialga45 on 6/25/2015.
 */
public enum MessageScope {

    CHAT("chat");

    private final String name;

    MessageScope(final String name) {
        this.name = name;
    }

    public final String toString() {
        return this.name;
    }

    public static MessageScope getScope(final String name) {
        for (MessageScope scope : values()) {
            if (scope.toString().equals(name)) {
                return scope;
            }
        }
        return MessageScope.CHAT;
    }

}

