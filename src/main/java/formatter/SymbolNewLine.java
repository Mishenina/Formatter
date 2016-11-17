package formatter;

/**
 * method for formatting.
 */
class SymbolNewLine implements Symbol {
    /**
     * new style format.
     */
    private StyleFormat styleFormat;

    /**
     * method for processing a symbol.
     *
     * @param c           input symbol
     * @param space       number of space
     * @param styleFormat current style format
     * @return corrected symbols
     */
    public String processSymbol(final char c, final int space, final StyleFormat styleFormat) {
        String str = "";
        str += '\n';
        for (int i = 0; i < styleFormat.indent * space; i++) {
            str += ' ';
        }
        styleFormat.setOnelineComment(false);
        styleFormat.setCharLiteral(false);
        styleFormat.setStringLiteral(false);
        styleFormat.setPreviousSymbol(c);
        this.styleFormat = styleFormat;
        return str;
    }

    /**
     * get style format.
     * @return style format
     */
    public StyleFormat getStyleFormat() {
        return styleFormat;
    }
}
