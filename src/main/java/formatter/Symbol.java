package formatter;

/**
 * symbol interface.
 */
public interface Symbol {
    /**
     * method for processing a symbol.
     *
     * @param c           input symbol
     * @param space       number of space
     * @param styleFormat current style format
     * @return corrected symbols
     */
    String processSymbol(char c, int space, StyleFormat styleFormat);

    /**
     * new style format.
     */
    StyleFormat styleFormat = null;

    /**
     * get style format.
     * @return style format
     */
    StyleFormat getStyleFormat();
}

