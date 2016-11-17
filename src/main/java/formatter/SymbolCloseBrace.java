package formatter;

/**
 * Symbol close brace.
 */
class SymbolCloseBrace implements Symbol {
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
    public  final String processSymbol(final char c, final int space, final StyleFormat styleFormat) {
        if (!styleFormat.multilineComment && !styleFormat.onelineComment) {
            String str = "";
            styleFormat.setIndent(--styleFormat.indent);
            str += '\n';
            for (int i = 0; i < space * styleFormat.indent; i++) {
                str += ' ';
            }
            str += c;
            str += '\n';

            for (int i = 0; i < space * styleFormat.indent; i++) {
                str += ' ';
            }
            styleFormat.setPreviousSymbol(c);
            this.styleFormat = styleFormat;
            return str;
        } else {
            styleFormat.setIndent(styleFormat.indent);
            styleFormat.setPreviousSymbol(c);
            this.styleFormat = styleFormat;
            return String.valueOf(c);
        }

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
