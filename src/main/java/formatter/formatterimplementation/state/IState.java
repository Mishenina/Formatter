package formatter.formatterimplementation.state;

/**
 * formatter state interface.
 */
public interface IState {

    /**
     * indent.
     */
    int indent = 0;



    /**
     * set current indent.
     *
     * @param value value
     */
     void setIndent(int value);

    /**
     * get current indent.
     *
     * @return current indent
     */
    int getIndent();

}
