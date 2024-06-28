package it.unibs.fp.spracolib;

public enum TermColors {
    /**
     * Useful to display text and background in non boring, default colors. It uses ANSI escape sequences.
     */

    //Resets the terminal color
    RESET("\u001B[0m"),

    //applies bold, italics or underlined formatting
    BOLD("\u001B[1m"),
    ITALICS("\u001B[3m"),
    UNDERLINED("\u001B[4m"),

    //makes the text blink
    SLOW_BLINK("\u001B[5m"),

    //applies a color to the text
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    //applies a color to the background
    BG_BLACK("\u001B[40m"),
    BG_RED("\u001B[41m"),
    BG_GREEN("\u001B[42m"),
    BG_YELLOW("\u001B[43m"),
    BG_BLUE("\u001B[44m"),
    BG_MAGENTA("\u001B[45m"),
    BG_CYAN("\u001B[46m"),
    BG_WHITE("\u001B[47m"),

    ;

    private final String termColor;
    private TermColors(String s) {
        termColor = s;
    }

    @Override
    public String toString(){
        return termColor;
    }
}
