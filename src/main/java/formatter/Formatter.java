package formatter;


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

            while (in.ready()) {
                char symbol = in.readChar();
                if (symbol == '\"') {
                    stringLiteral = !stringLiteral;
                }
                if (symbol == '\'') {
                    charLiteral = !charLiteral;
                }
                if (!charLiteral && !stringLiteral) {
                    switch (symbol) {
                        case ';':
                            if (!multilineComment && !onelineComment) {
                                out.write(symbol);
                                out.write('\n');
                                for (int i = 0; i < space * indent; i++) {
                                    out.write(' ');
                                }
                            } else {
                                out.write(symbol);
                            }
                            break;
                        case '{':
                            if (!multilineComment && !onelineComment) {
                                indent++;
                                out.write(' ');
                                out.write(symbol);

                                out.write('\n');
                                for (int i = 0; i < space * indent; i++) {
                                    out.write(' ');
                                }

                            } else {
                                out.write(symbol);
                            }
                            break;
                        case '}':
                            if (!multilineComment && !onelineComment) {
                                indent--;
                                out.write('\n');
                                for (int i = 0; i < space * indent; i++) {
                                    out.write(' ');
                                }
                                out.write(symbol);

                                out.write('\n');
                                for (int i = 0; i < space * indent; i++) {
                                    out.write(' ');
                                }

                            } else {
                                out.write(symbol);
                            }
                            break;
                        case '/':
                            if (previousSymbol == '*') {
                                multilineComment = false;
                            }
                            if (previousSymbol == '/') {
                                onelineComment = true;
                            }
                            out.write(symbol);
                            break;
                        case '*':
                            if (previousSymbol == '/') {
                                multilineComment = true;
                            }
                            out.write(symbol);
                            break;
                        case '\n':
                            onelineComment = false;
                            out.write(symbol);
                        default:
                            out.write(symbol);
                            break;


                    }

                    previousSymbol = symbol;
                } else {
                    out.write(symbol);
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
         * @param message message
         * @param cause exception
         */
        FormatterException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
