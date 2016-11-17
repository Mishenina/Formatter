package formatter;

/**
 * Symbol asterisk.
 */
class SymbolAsterisk implements Symbol {
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
    public final String processSymbol(final char c, final int space, final StyleFormat styleFormat) {
        if (styleFormat.previousSymbol == '/') {
            styleFormat.setMultilineComment(true);
        }
        styleFormat.setPreviousSymbol(c);
        this.styleFormat = styleFormat;
        return String.valueOf(c);
    }

    /**
     * get style format.
     *
     * @return style format
     */
    public final StyleFormat getStyleFormat() {
        return styleFormat;
    }
}
