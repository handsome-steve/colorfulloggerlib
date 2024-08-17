package net.handsomesteve.logger;

import net.handsomesteve.api.ColorfulLogger;
import net.handsomesteve.api.ansi.AnsiColorBackground;
import net.handsomesteve.api.ansi.AnsiColorText;

import java.util.Objects;

/**
 * Utility class for generating formatted log messages with ANSI color support.
 * This class provides methods to easily output initialization, registration, and generation messages
 * with contextual and color enhancements to the debug console during mod development.
 *
 * <p>It uses {@link ColorfulLogger} to ensure all messages are consistently formatted and visible.
 * This class is not intended to be instantiated or extended.</p>
 *
 * @author handsome-steve
 * @version 2.1.0
 * @since 2.1.0
 */
public abstract class LoggerOutputSnippets
{
    private static final ColorfulLogger LOGGER = ColorfulLogger.getInstance();
    private static final String ONLY_ON_DATAGEN = "(Only called on task '[runDatagen]')";
    private static final String AS_POOL_CHILD = "(as Pool Child)";

    /**
     * Private constructor to prevent instantiation.
     */
    private LoggerOutputSnippets() { throw new AssertionError(); }

    /**
     * Ensures that the logger instance is always available within this class.
     *
     * @return the singleton instance of {@link ColorfulLogger}.
     * @throws NullPointerException if the logger instance is null.
     */
    private static ColorfulLogger getLogger() {
        return Objects.requireNonNull(
                LOGGER,
                "[ERROR]: Internal parameter 'LOGGER' must not be null '@LoggerOutputSnippets.getLogger()'. Ensure that the 'ColorfulLogger' is declared, in your mod's main file, by calling '@ColorfulLogger.getInstance(String)'."
        );
    }

    /**
     * Logs a message indicating the start of an initialization process, with options for color and contextual detail.
     *
     * @param initializationTarget the target of the initialization.
     * @param onlyOnDatagen flag to indicate if the message should state it is only relevant during data generation.
     * @param colorText the foreground color for the message.
     * @param colorBackground the background color for the message.
     */
    public static void initializingSnippet(String initializationTarget, boolean onlyOnDatagen, AnsiColorText colorText, AnsiColorBackground colorBackground)
    {
        if(onlyOnDatagen) {
            getLogger().info(
                    String.format(" >> Initializing: %s %s ", initializationTarget, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                    colorText, colorBackground
            );
            return;
        }
        getLogger().info(
                String.format(" >> Initializing: %s ", initializationTarget),
                colorText, colorBackground
        );
    }

    /**
     * Logs a message indicating the registration of a mod component, with options for indentation and color.
     *
     * @param registrationTarget the target of registration.
     * @param identifierPath the unique identifier path for the registered item.
     * @param asPoolChild flag to indicate if the registration is part of a larger pool.
     * @param colorText the color for the message.
     */
    public static void registeringSnippet(String registrationTarget, String identifierPath, boolean asPoolChild, AnsiColorText colorText)
    {
        if(asPoolChild) {
            getLogger().info(
                    String.format("\t\t> Registering %s %s: %s", registrationTarget, identifierPath, LoggerOutputSnippets.AS_POOL_CHILD),
                    colorText
            );
            return;
        }
        getLogger().info(
                String.format("\t\t>> Registering %s: %s", registrationTarget, identifierPath),
                colorText
        );
    }

    /**
     * Logs a message indicating the generation of a mod component, with options for detailed context and color.
     *
     * @param generationTarget the target of generation.
     * @param asPoolChild flag to indicate if the generation is part of a larger pool.
     * @param onlyOnDatagen flag to indicate if the message should state it is only relevant during data generation.
     * @param colorText the foreground color for the message.
     * @param colorBackground the background color for the message.
     */
    public static void generatingSnippet(String generationTarget, boolean asPoolChild, boolean onlyOnDatagen, AnsiColorText colorText, AnsiColorBackground colorBackground)
    {
        if(onlyOnDatagen) {
            if(asPoolChild)
            {
                getLogger().info(
                        String.format(" >> Generating %s %s %s ", generationTarget, LoggerOutputSnippets.AS_POOL_CHILD, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                        colorText, colorBackground
                );
                return;
            }
            getLogger().info(
                    String.format(" >> Generating %s %s ", generationTarget, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                    colorText, colorBackground
            );
            return;
        }
        if(asPoolChild) {
            getLogger().info(
                    String.format(" >> Generating %s %s ", generationTarget, LoggerOutputSnippets.AS_POOL_CHILD),
                    colorText, colorBackground
            );
            return;
        }
        getLogger().info(
                String.format(" >> Generating %s", generationTarget),
                colorText, colorBackground
        );
    }

    public static void creatingJsonSnippet()
    {

    }

    public static void addingToJsonSnippet()
    {

    }

}
