package FormatterImplementation;

/**
 * formatter state char literal.
 */
class StateCharLiteral implements IState {

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
        previousSymbol = c;
        if (c == '\'') {
            return new StateDefault();
        } else {
            return new StateCharLiteral();
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