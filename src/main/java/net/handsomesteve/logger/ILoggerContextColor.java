package net.handsomesteve.logger;

import net.handsomesteve.api.ansi.AnsiColorBackground;
import net.handsomesteve.api.ansi.AnsiColorText;

public interface ILoggerContextColor {

    AnsiColorText COLOR_TEXT_HEADING = AnsiColorText.ANSI_BRIGHT_CYAN;
    AnsiColorText COLOR_TEXT_PARAGRAPH = AnsiColorText.ANSI_GREEN;
    AnsiColorBackground COLOR_BACKGROUND_HEADING = AnsiColorBackground.ANSI_BLACK_BACK;
    AnsiColorText COLOR_TEXT_ERROR = AnsiColorText.ANSI_BRIGHT_RED;

}
