package formatter;

/**
 * Symbol slash.
 */
class SymbolSlash implements Symbol {
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
        if (styleFormat.previousSymbol == '*') {
            styleFormat.setMultilineComment(false);
        }
        if (styleFormat.previousSymbol == '/') {
            styleFormat.setOnelineComment(true);
        }
        styleFormat.setPreviousSymbol(c);
        this.styleFormat = styleFormat;
        return String.valueOf(c);
    }

    /**
     * get style format.
     * @return style format
     */
    public StyleFormat getStyleFormat() {
        return styleFormat;
    }
}
