package com.handsomesteve.api.ansi;

public enum AnsiColor
{
    ANSI_RESET("\u001B[0m");

    private AnsiColor(final String value)
    {
        this.value = value;
    }

    private final String value;

    public String getValue()
    {
        return value;
    }
}
