package formatter.formatterimplementation.state;

/**
 * formatter state interface.
 */
public interface IState {

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
