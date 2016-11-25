package FormatterImplementation;

/**
 * formatter state multiline comment.
 */
class StateMultilineComment implements IState {

    /**
     * indent.
     */
    private int indent;

    /**
     * previous symbol.
     */
    private char previousSymbol;


    /**
     * determine next state.
     *
     * @param c current char
     * @return next state
     */
    public IState getNextState(final char c) {
        if (c == '*' && previousSymbol == '/') {
            previousSymbol = c;
            return new StateDefault();
        } else {
            previousSymbol = c;
            return new StateMultilineComment();
        }
    }

    /**
     * set current indent.
     *
     * @param value value
     */
    public void setIndent(final int value) {
        this.indent = value;
    }

    /**
     * get current indent.
     *
     * @return current indent
     */
    public int getIndent() {
        return this.indent;
    }

    /**
     * set current previous symbol.
     *
     * @param value value
     */
    public void setPreviousSymbol(final char value) {
        this.previousSymbol = value;
    }

    /**
     * get current previous symbol.
     *
     * @return current previous symbol
     */
    public char getPreviousSymbol() {
        return this.previousSymbol;
    }
}
