package formatter.formatterimplementation.state;

/**
 * formatter state default.
 */
public class StateDefault implements IState {

    /**
     * default constructor.
     * @param indent current indent
     */
    public StateDefault(final int indent) {
        setIndent(indent);
    }
    /**
     * indent.
     */
    private int indent;

    /**
     * set current indent.
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
