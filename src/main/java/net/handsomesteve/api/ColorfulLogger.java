package net.handsomesteve.api;

import net.handsomesteve.api.ansi.AnsiColor;
import net.handsomesteve.api.ansi.AnsiColorBackground;
import net.handsomesteve.api.ansi.AnsiColorText;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * <p>Package {@link net.handsomesteve.api}</p>
 *
 * <h2>Colorful Logger</h2>
 * <p>{@code public final class}</p>
 * <p>
 * A utility class for logging with ANSI colors in Minecraft mod development environments.
 * Provides methods to output colored messages to the console, helping in debugging and log differentiation.
 * This class uses ANSI codes to add color configurations to the log output and ensures singleton access
 * to maintain a unified logging interface across the mod.
 * </p>
 * <p>There are ANSI codes provided as {@link Enum}.</p>
 *
 * <h3>Typical usage pattern:
 *
 * <pre><font color="orange">  import net.handsomesteve.api.ColorfulLogger;
 * import net.handsomesteve.api.ansi.AnsiColorBackground;
 * import net.handsomesteve.api.ansi.AnsiColorText;</font>
 *
 * public class FabricMod implements ModInitializer {
 *
 *      public static final String MOD_ID = "your-mod-id";
 *      <font color="orange">public static final ColorfulLogger LOGGER = ColorfulLogger.getInstance("your-mod-id", true);</font>
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
 * <p>
 * Please consider that this is a work in progress. Users are welcome contribute ideas or pull requests to the github repository:
 * <a href="https://github.com/handsome-steve/colorfulloggerlib">https://github.com/handsome-steve/colorfulloggerlib</a>
 * </p>
 *
 * @see AnsiColor
 * @see AnsiColorText
 * @see AnsiColorBackground
 *
 * @author handsome-steve
 * @version 1.1.0
 * @since 1.0.0
 */

public final class ColorfulLogger
{

    /**
     * Singleton instance of the logger.
     */
    private static ColorfulLogger INSTANCE;

    /**
     * The primary logger used for output.
     */
    private final Logger LOGGER;

    /**
     * Retrieves the current logger instance.
     *
     * @return the active Logger instance
     */
    public Logger getLogger()
    {
        return this.LOGGER;
    }

    /**
     * Flag to indicate if debugging is enabled.
     */
    private boolean debug;

    /**
     * Checks if debugging is enabled.
     *
     * @return true if debugging is enabled, false otherwise.
     */
    public boolean getDebug() { return this.debug; }

    /**
     * Sets the debugging state.
     *
     * @param value true to enable debugging, false to disable.
     */
    public void setDebug(boolean value) { this.debug = value; }

    /**
     * Private constructor for creating a logger instance with a mod identifier.
     *
     * @param modId the mod identifier used to create the logger
     */
    private ColorfulLogger(@NotNull String modId)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = true;
    }

    /**
     * Private constructor for creating a logger instance with a mod identifier and a debug flag.
     *
     * @param modId the mod identifier used to create the logger
     * @param showDebug true to enable debugging output, false otherwise
     */
    private ColorfulLogger(@NotNull String modId, boolean showDebug)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = showDebug;
    }

    /**
     * Retrieves the singleton logger instance for the specified mod ID. If no instance exists, it creates one.
     *
     * @param modId the unique identifier for the mod, must not be null
     * @return the singleton ColorfulLogger instance
     * @throws NullPointerException if {@code modId} is null, with an explanation in the error message
     */
    @NotNull
    public static synchronized ColorfulLogger getInstance(@NotNull String modId)
    {
        if(INSTANCE == null) {
            INSTANCE = new ColorfulLogger(
                    Objects.requireNonNull(
                            modId,
                            "[ERROR]: Parameter 'modId' cannot be null at '@ColorfulLogger.getInstance(String)'."
                    )
            );
        }
        return INSTANCE;
    }

    /**
     * Retrieves or creates a singleton logger instance with a specific debug setting for the specified mod ID.
     *
     * @param modId the mod identifier, cannot be null
     * @param showDebug true enables debugging, false disables it
     * @return the singleton ColorfulLogger instance
     * @throws NullPointerException if {@code modId} is null, with an error message specifying the issue
     */
    @NotNull
    public static synchronized ColorfulLogger getInstance(@NotNull String modId, boolean showDebug)
    {
        if(INSTANCE == null) {
            INSTANCE = new ColorfulLogger(
                    Objects.requireNonNull(
                            modId,
                            "[ERROR]: Parameter 'modId' cannot be null at '@ColorfulLogger.getInstance(String, boolean)'."
            ),
            showDebug);
        }
        return INSTANCE;
    }

    /**
     * Gets the already-initialized singleton instance of {@link ColorfulLogger}.
     * This method can only be called after the singleton has been initialized with parameters.
     *
     * @return The singleton instance of {@link ColorfulLogger}.
     * @throws IllegalStateException if the singleton has not been initialized with parameters.
     */
    public static synchronized ColorfulLogger getInstance() {
        if(INSTANCE == null) {
            throw new IllegalStateException("'@ColorfulLogger' is not initialized. Call '@ColorfulLogger.getInstance(String, boolean)' first.");
        }
        return INSTANCE;
    }

    /**
     * Prints out a plain message via the internal {@link org.slf4j.Logger} without any coloring applied to the console.
     *
     * @param message the message to log
     */
    public void info(String message)
    {
        if(debug)
            LOGGER.info(message);
    }

    /**
     * <Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground only.
     *
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link AnsiColorText}.
     */
    public void info(String message, AnsiColorText ansiColorText)
    {
        if(debug)
            LOGGER.info("{}{}{}", ansiColorText.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

    /**
     * <Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground and background.
     *
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link AnsiColorText}.
     * @param ansiColorBackground Takes an ANSI color value from {@link AnsiColorBackground}.
     */
    public void info(String message, AnsiColorText ansiColorText, AnsiColorBackground ansiColorBackground)
    {
        if(debug)
            LOGGER.info("{}{}{}{}", ansiColorText.getValue(), ansiColorBackground.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

}
