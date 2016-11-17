package formatter;

/**
 * state format.
 */
class StyleFormat {
    /**
     * state one line comment.
     */
    boolean onelineComment;
    /**
     * state multiline comment.
     */
    boolean multilineComment;
    /**
     * state char literal.
     */
    boolean charLiteral;
    /**
     * state string literal.
     */
    boolean stringLiteral;
    /**
     * previous symbol.
     */
    char previousSymbol;
    /**
     * the number of indents.
     */
    int indent;

    /**
     * set oneline comment.
     * @param value value
     */
    void setOnelineComment(final boolean value) {
        this.onelineComment = value;
    }
/**
 * set multiline comment.
 *@param value value
 */
    void setMultilineComment(final boolean value) {
        this.multilineComment = value;
    }

    /**
     * set char literal.
     * @param value value
     */
    void setCharLiteral(final boolean value) {
        this.charLiteral = value;
    }

    /**
     * set string literal.
     * @param value value
     */
    void setStringLiteral(final boolean value) {
        this.stringLiteral = value;
    }

    /**
     * set pevious symbol.
     * @param value value
     */

    public void setPreviousSymbol(final char value) {
        this.previousSymbol = value;
    }

    /**
     * set indent.
     * @param value value
     */
    void setIndent(final int value) {
        this.indent = value;
    }

}

