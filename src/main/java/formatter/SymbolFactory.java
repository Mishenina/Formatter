package formatter;

/**
 * object class selection.
 */
final class SymbolFactory {

    /**
     * object class selection.
     *
     * @param type input symbol
     * @return create object
     */
    static Symbol getSymbol(final char type) {
        Symbol symbol;
        if (type == ';') {
            symbol = new SymbolSemicolon();
        } else if (type == '{') {
            symbol = new SymbolOpenBrace();
        } else if (type == '}') {
            symbol = new SymbolCloseBrace();
        } else if (type == '/') {
            symbol = new SymbolSlash();
        } else if (type == '*') {
            symbol = new SymbolAsterisk();
        } else if (type == '\'') {
            symbol = new SymbolApostrophe();
        } else if (type == '\"') {
            symbol = new SymbolQuote();
        } else if (type == '\n') {
            symbol = new SymbolNewLine();
        } else {
            symbol = new SymbolOther();
        }

        return symbol;
    }

    /**
     *  default constructor.
     */
    private SymbolFactory() {

    }
}
