package FormatterImplementation.State;

/**
 * formatter state char literal.
 */
class StateCharLiteral implements IState {


    /**
     * default constructor.
     * @param indent current indent
     *
     */
    StateCharLiteral(final int indent) {
        setIndent(indent);
    }


    /**
     * indent.
     */
    private int indent;


    /**
     * determine next state.
     *
     * @param c current char
     * @return next state
     */
    public IState getNextState(final char c) {
        if (c == '\'') {
            return new StateDefault(indent);
        } else {
            return new StateCharLiteral(indent);
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


}
