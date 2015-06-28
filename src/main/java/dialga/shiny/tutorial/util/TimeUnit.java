package dialga.shiny.tutorial.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ElectroidFilms on 6/27/15.
 */
public enum TimeUnit {

    TICKS  ('t', 1),
    SECONDS('s', 20),
    MINUTES('m', 20 * 60),
    HOURS  ('h', 20 * 60 * 60),
    DAYS   ('d', 20 * 60 * 60 * 24);

    private final char character;
    private final int ticks;

    TimeUnit(char character, int ticks) {
        this.character = character;
        this.ticks = ticks;
    }

    public char getChar() {
        return this.character;
    }

    public int toTicks() {
        return this.ticks;
    }

    public static int toTicks(String string) {
        int ticks = 0;
        for (TimeUnit unit : TimeUnit.values()) {
            Matcher regex = Pattern.compile("[0-9]{1,16}" + unit.getChar()).matcher(string);
            while (regex.find()) {
                ticks += unit.toTicks() * Integer.parseInt(regex.group().replaceAll(unit.getChar() + "", ""));
            }
        }
        return ticks;
    }

}
