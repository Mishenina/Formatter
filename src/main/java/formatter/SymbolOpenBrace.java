package formatter;

/**
 * Symbol open brace.
 */
class SymbolOpenBrace implements Symbol {
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
        if (!styleFormat.multilineComment && !styleFormat.onelineComment) {
            String str = "";
            styleFormat.setIndent(++styleFormat.indent);
            str += c;
            str += '\n';
            for (int i = 0; i < styleFormat.indent * space; i++) {
                str += ' ';
            }
            styleFormat.setPreviousSymbol(c);
            this.styleFormat = styleFormat;
            return str;
        } else {
            styleFormat.setPreviousSymbol(c);
            this.styleFormat = styleFormat;
            return String.valueOf(c);
        }
    }

    /**
     * get style format.
     * @return style format
     */
    public final StyleFormat getStyleFormat() {
        return styleFormat;
    }
}
