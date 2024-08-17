package net.handsomesteve.logger;

import net.handsomesteve.api.ColorfulLogger;
import net.handsomesteve.api.ansi.AnsiColorBackground;
import net.handsomesteve.api.ansi.AnsiColorText;

public abstract class LoggerOutputSnippets
{
    private static final ColorfulLogger LOGGER = ColorfulLogger.getInstance();
    private static final String ONLY_ON_DATAGEN = "(Only called on task '[runDatagen]')";
    private static final String AS_POOL_CHILD = "(as Pool Child)";

    private LoggerOutputSnippets() { throw new AssertionError(); }

    public static void initializingSnippet(String initializationTarget, boolean onlyOnDatagen, AnsiColorText colorText, AnsiColorBackground colorBackground)
    {
        if(onlyOnDatagen) {
            LOGGER.info(
                    String.format(" >> Initializing: %s %s ", initializationTarget, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                    colorText, colorBackground
            );
            return;
        }
        LOGGER.info(
                String.format(" >> Initializing: %s ", initializationTarget),
                colorText, colorBackground
        );
    }

    public static void registeringSnippet(String registrationTarget, String identifierPath, boolean asPoolChild, AnsiColorText colorText)
    {
        if(asPoolChild) {
            LOGGER.info(
                    String.format("\t\t> Registering %s %s: %s", registrationTarget, identifierPath, LoggerOutputSnippets.AS_POOL_CHILD),
                    colorText
            );
            return;
        }
        LOGGER.info(
                String.format("\t\t>> Registering %s: %s", registrationTarget, identifierPath),
                colorText
        );
    }

    public static void generatingSnippet(String generationTarget, boolean asPoolChild, boolean onlyOnDatagen, AnsiColorText colorText, AnsiColorBackground colorBackground)
    {
        if(onlyOnDatagen) {
            if(asPoolChild)
            {
                LOGGER.info(
                        String.format(" >> Generating %s %s %s ", generationTarget, LoggerOutputSnippets.AS_POOL_CHILD, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                        colorText, colorBackground
                );
                return;
            }
            LOGGER.info(
                    String.format(" >> Generating %s %s ", generationTarget, LoggerOutputSnippets.ONLY_ON_DATAGEN),
                    colorText, colorBackground
            );
            return;
        }
        if(asPoolChild) {
            LOGGER.info(
                    String.format(" >> Generating %s %s ", generationTarget, LoggerOutputSnippets.AS_POOL_CHILD),
                    colorText, colorBackground
            );
            return;
        }
        LOGGER.info(
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
