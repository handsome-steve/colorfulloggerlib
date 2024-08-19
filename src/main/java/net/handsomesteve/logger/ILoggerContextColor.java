package net.handsomesteve.logger;

import net.handsomesteve.api.ansi.AnsiColorBackground;
import net.handsomesteve.api.ansi.AnsiColorText;

/**
 * Interface defining ANSI color constants used for logging outputs.
 * This provides a standardized set of color configurations for log messages,
 * simplifying the inclusion of color formatting in logs without repeating color
 * definitions across different classes or files.
 *
 * <p>This interface ensures consistent coloring for different types of log messages
 * such as headings, paragraphs, and error messages, enhancing readability and
 * differentiation in console outputs.</p>
 *
 * @author handsome-steve
 * @version 2.2.0
 * @since 2.1.0
 */
public interface ILoggerContextColor {

    /**
     * Bright cyan color for headings in log outputs.
     */
    AnsiColorText COLOR_TEXT_HEADING = AnsiColorText.ANSI_BRIGHT_CYAN;


    /**
     * Green color for paragraph text in log outputs.
     */
    AnsiColorText COLOR_TEXT_PARAGRAPH = AnsiColorText.ANSI_GREEN;

    /**
     * Black background color for headings in log outputs.
     */
    AnsiColorBackground COLOR_BACKGROUND_HEADING = AnsiColorBackground.ANSI_BLACK_BACK;

    /**
     * Bright red color for error messages in log outputs.
     */
    AnsiColorText COLOR_TEXT_ERROR = AnsiColorText.ANSI_BRIGHT_RED;

}
