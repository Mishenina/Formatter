package formatter;


import reader.IReader;
import writer.IWriter;

/**
 * Formatter from in to out.
 */
public class Formatter implements IFormatter {
    /**
     * text formatting.
     *
     * @param in  input text
     * @param out output text
     * @throws FormatterException when formatting failed
     */
    public final void format(final IReader in, final IWriter out) throws FormatterException {

        try {
            final int space = 4;
            int indent = 0;
            boolean onelineComment = false;
            boolean multilineComment = false;
            boolean charLiteral = false;
            boolean stringLiteral = false;
            char previousSymbol = ' ';
            StyleFormat styleFormat = new StyleFormat();

            while (in.ready()) {

                char symbol = in.readChar();
                Symbol s = SymbolFactory.getSymbol(symbol);
                String str = s.processSymbol(symbol, space, styleFormat);
                styleFormat = s.getStyleFormat();
                for (int i = 0; i < str.length(); i++) {
                    out.write(str.charAt(i));
                }
            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }


    }

    /**
     * Formatter exception.
     */
    public class FormatterException extends Exception {
        /**
         * Formatter exception.
         *
         * @param message message
         * @param cause   exception
         */
        FormatterException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
