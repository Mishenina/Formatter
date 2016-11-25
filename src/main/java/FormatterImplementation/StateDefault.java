package FormatterImplementation;

/**
 * formatter state default.
 */
class StateDefault implements IState {


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
        if (previousSymbol == '/' && c == '/') {
            previousSymbol = c;
            return new StateOnelineComment();
        } else if (previousSymbol == '/' && c == '*') {
            previousSymbol = c;
            return new StateMultilineComment();
        } else if (c == '\"') {
            previousSymbol = c;
            return new StateStringLiteral();
        } else if (c == '\'') {
            previousSymbol = c;
            return new StateCharLiteral();
        } else {
            previousSymbol = c;
            return new StateDefault();
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
