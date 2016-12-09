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
     * determine next state.
     *
     * @param c current char
     * @return next state
     */
    IState getNextState(String c);

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
