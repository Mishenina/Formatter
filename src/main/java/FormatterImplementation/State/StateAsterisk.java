package FormatterImplementation.State;

/**
 * formatter state asterisk.
 */
class StateAsterisk implements IState {

    /**
     * default constructor.
     * @param indent current indent
     *
     */
    StateAsterisk(final int indent) {
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
        if (c == '/') {
            return new StateDefault(indent);
        } else {
            return new StateMultilineComment(indent);
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

