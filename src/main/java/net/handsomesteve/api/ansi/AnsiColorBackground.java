package net.handsomesteve.api.ansi;

public enum AnsiColorBackground
{
    ANSI_BLACK_BACK("\u001B[40m"),
    ANSI_RED_BACK("\u001B[41m"),
    ANSI_GREEN_BACK("\u001B[42m"),
    ANSI_YELLOW_BACK("\u001B[43m"),
    ANSI_BLUE_BACK("\u001B[44m"),
    ANSI_MAGENTA_BACK("\u001B[45m"),
    ANSI_CYAN_BACK("\u001B[46m"),
    ANSI_WHITE_BACK("\u001B[47m"),
    ANSI_BRIGHT_BLACK_BACK("\u001B[100m"),
    ANSI_BRIGHT_RED_BACK("\u001B[101m"),
    ANSI_BRIGHT_GREEN_BACK("\u001B[102m"),
    ANSI_BRIGHT_YELLOW_BACK("\u001B[103m"),
    ANSI_BRIGHT_BLUE_BACK("\u001B[104m"),
    ANSI_BRIGHT_MAGENTA_BACK("\u001B[105m"),
    ANSI_BRIGHT_CYAN_BACK("\u001B[106m"),
    ANSI_BRIGHT_WHITE_BACK("\u001B[107m");

    private AnsiColorBackground(final String value)
    {
        this.value = value;
    }

    private final String value;

    public String getValue()
    {
        return value;
    }
}
