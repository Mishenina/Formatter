package formatter.formatterimplementation.state;

/**
 * Created by anna on 09.12.16.
 */
public class StateFor  implements IState {

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

