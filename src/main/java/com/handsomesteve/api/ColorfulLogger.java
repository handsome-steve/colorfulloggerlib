package com.handsomesteve.api;

import com.handsomesteve.api.ansi.AnsiColor;
import com.handsomesteve.api.ansi.AnsiColorBackground;
import com.handsomesteve.api.ansi.AnsiColorText;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Package {@link com.handsomesteve.api}
 * <h2>Colorful Logger
 * <p>public final class
 * <p>This class aims at providing a simple, yet robust way, of adding colors to the foreground and background of your debug console when creating your Minecraft Mods.
 * <p>This is achieved by utilizing pre-configured ANSI codes provided as an {@link Enum}.
 *
 * <h3>Typical usage pattern:
 *
 * <pre><font color="orange">  import com.handsomesteve.api.ColorfulLogger;
 * import com.handsomesteve.api.ansi.AnsiColorBackground;
 * import com.handsomesteve.api.ansi.AnsiColorText;</font>
 *
 * public class FabricMod implements ModInitializer {
 *
 *      public static final String MOD_ID = "your-mod-id";
 *      <font color="orange">public static final ColorfulLogger LOGGER = new ColorfulLogger("your-mod-id", false);</font>
 *
 *      &#64Override
 *      public void onInitialize() {
 *              <font color="orange">LOGGER.info(">>> This is a plain message without any colouring");
 *
 *              LOGGER.info(">>> I want some green text", AnsiColorText.ANSI_BRIGHT_GREEN);
 *
 *              LOGGER.info(">>> I want some red text with a black background",
 *                      AnsiColorText.ANSI_BRIGHT_RED, AnsiColorBackground.ANSI_BLACK_BACK);</font>
 *      }
 * }
 * </pre>
 *
 * <p>Please consider that this is a work in progress. Users are welcome contribute ideas or pull requests to the github repository: <a href="https://github.com/handsome-steve/colorfulloggerlib">https://github.com/handsome-steve/colorfulloggerlib</a> </p>
 * @author handsome-steve
 * @version 1.0.1
 */

public final class ColorfulLogger
{
    /**
     * <p>Initializes {@link org.slf4j.Logger} as a {@code public final LOGGER} variable to be set by the constructor.
     */
    private final Logger LOGGER;

    /**
     * <p>Getter method for the class declared private final variable {@code LOGGER}.
     * @return Value of the private final variable {@code LOGGER} as type {@link Logger}.
     */
    public Logger getLogger()
    {
        return this.LOGGER;
    }

    /**
     * <p>Initializes {@code debug} as a {@code private} {@link Boolean} variable to be set by the constructor.
     */
    private boolean debug;
    /**
     * <p>Getter method for the class declared private variable {@code debug}.
     * @return Value of the private variable {@code debug} as type {@link Boolean}.
     */
    public boolean getDebug() { return this.debug; }
    /**
     * <p>Setter method for the class declared private variable {@code debug}.
     * @param value Takes the new value of the private variable {@code debug} as a {@link Boolean}.
     */
    public void setDebug(boolean value) { this.debug = value; }

    /**
     * <p>Initial constructor of {@link com.handsomesteve.api.ColorfulLogger}
     * @param modId This parameter takes a {@link String} as a value, this is usually the Minecraft Mod's {@code MOD_ID}.
     */
    public ColorfulLogger(@NotNull String modId)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = true;
    }

    /**
     * <p>Overload constructor of {@link com.handsomesteve.api.ColorfulLogger}
     * @param modId This parameter takes a {@link String} as a value, this is usually the Minecraft Mod's {@code MOD_ID}.
     * @param hideDebug This parameter takes a {@link Boolean} as a value to determine whether the {@link com.handsomesteve.api.ColorfulLogger} should hide its console output.
     */
    public ColorfulLogger(@NotNull String modId, boolean hideDebug)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = !hideDebug;
    }

    /**
     * <p>Prints out a plain message via the internal {@link org.slf4j.Logger} without any coloring applied to the console.
     * @param message Takes the message to be printed out as a {@link String}.
     */
    public void info(String message)
    {
        if(debug)
            LOGGER.info(message);
    }

    /**
     * <p>Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground only.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorText}.
     */
    public void info(String message, AnsiColorText ansiColorText)
    {
        if(debug)
            LOGGER.info("{}{}{}", ansiColorText.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

    /**
     * <p>Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground and background.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorText}.
     * @param ansiColorBackground Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorBackground}.
     */
    public void info(String message, AnsiColorText ansiColorText, AnsiColorBackground ansiColorBackground)
    {
        if(debug)
            LOGGER.info("{}{}{}{}", ansiColorText.getValue(), ansiColorBackground.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

}
