package formatter.formatterimplementation.state;

/**
 * formatter state oneline comment.
 */
class StateOnelineComment implements IState {


    /**
     * indent.
     */
    private int indent;


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
     * default constructor.
     * @param indent current indent
     *
     */
    StateOnelineComment(final int indent) {
        setIndent(indent);
    }
}
