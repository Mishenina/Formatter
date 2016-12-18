package formatter.formatterimplementation.state;

/**
 * formatter state for loop.
 */
class StateFor  implements IState {

    /**
     * default constructor.
     * @param indent current indent
     *
     */
    StateFor(final int indent) {
        setIndent(indent);
    }


    /**
     * indent.
     */
    private int indent;


    /**
     * set current indent.
     *
     * @param value value
     */
    public final void setIndent(final int value) {
        this.indent = value;
    }

    /**
     * get current indent.
     *
     * @return current indent
     */
    public final int getIndent() {
        return this.indent;
    }

}

