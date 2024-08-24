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
 * @version 2.0.0
 * @since 1.0.0
 */

public final class ColorfulLogger
{

    /**
     * Singleton instance of {@link ColorfulLogger}.
     */
    private static ColorfulLogger INSTANCE;

    /**
     * The primary logger used for output.
     */
    private final Logger LOGGER;

    /**
     * <h6>Retrieves the current logger instance.</h6>
     *
     * <p>This method retrieves the current {@link ColorfulLogger#LOGGER} instance from the {@link ColorfulLogger} singleton instance.</p>
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
     * <h6>Checks if debugging is enabled.</h6>
     *
     * <p>This method retrieves the current value of {@link ColorfulLogger#debug} from the {@link ColorfulLogger} singleton instance.</p>
     *
     * @return true if debugging is enabled, false otherwise.
     */
    public boolean getDebug() { return this.debug; }

    /**
     * <h6>Sets the debugging state.</h6>
     *
     * <p>This method assigns the value of {@link ColorfulLogger#debug} from the {@link ColorfulLogger} singleton instance.</p>
     *
     * @param value true to enable debugging, false to disable.
     */
    public void setDebug(boolean value) { this.debug = value; }

    /**
     * <h6>Private constructor for creating a logger instance with a mod identifier.</h6>
     *
     * <p>
     * This constructor initializes the {@link ColorfulLogger#LOGGER} instance from
     * parameter values and defaults the {@link ColorfulLogger#debug} instance
     * to {@code true}.
     * </p>
     *
     * @param modId the mod identifier used to create the logger.
     */
    private ColorfulLogger(@NotNull String modId)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = true;
    }

    /**
     * <h6>Private constructor for creating a logger instance with a mod identifier and a debug flag.</h6>
     *
     * <p>
     * This constructor initializes the {@link ColorfulLogger#LOGGER} instance and
     * the {@link ColorfulLogger#debug} instance from parameter values.
     * </p>
     *
     * @param modId the mod identifier used to create the logger.
     * @param showDebug true to enable debugging output, false otherwise.
     */
    private ColorfulLogger(@NotNull String modId, boolean showDebug)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = showDebug;
    }

    /**
     * <h6>Retrieves the {@link ColorfulLogger} instance by parsing a specified mod ID.</h6>
     *
     * <p>
     * This method retrieve the {@code ColorfulLogger} singleton instance by parsing
     * a specified mod ID, if no instance exists, it creates one.
     * </p>
     *
     * @param modId the unique identifier for the mod, must not be null.
     * @return the singleton ColorfulLogger instance.
     * @throws NullPointerException if {@code modId} is null, with an explanation in the error message.
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
     * <h6>Retrieves the {@link ColorfulLogger} instance by parsing a specified mod ID and debug flag.</h6>
     *
     * <p>
     * This method retrieve the {@code ColorfulLogger} singleton instance by parsing
     * a specified mod ID and a debug flag, if no instance exists, it creates one.
     * </p>
     *
     * @param modId the mod identifier, cannot be null.
     * @param showDebug true enables debugging, false disables it..
     * @return the singleton ColorfulLogger instance.
     * @throws NullPointerException if {@code modId} is null, with an error message specifying the issue.
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
     * <h6>Retrieves the already-initialized singleton instance of {@link ColorfulLogger}.</h6>
     *
     * <p>This method can only be called after the singleton has been initialized with parameters.</p>
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
     * <h6>Default logger print method without color.</h6>
     *
     * <p>This method prints out a plain message via the internal {@link org.slf4j.Logger} without any coloring applied to the console.</p>
     *
     * @param message the message to log
     */
    public void info(String message)
    {
        if(debug)
            LOGGER.info(message);
    }

    /**
     * <h6>Overload logger print method with foreground color.</h6>
     *
     * <p>This overload method prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground only.</p>
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
     * <h6>Overload logger print method with foreground and background color.</h6>
     *
     * <p>This overload method prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground and background.</p>
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
