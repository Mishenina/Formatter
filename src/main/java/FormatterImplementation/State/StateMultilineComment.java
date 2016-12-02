package FormatterImplementation.State;

import java.util.HashMap;

/**
 * formatter state multiline comment.
 */
class StateMultilineComment implements IState {

    /**
     * control symbols map.
     */
    private HashMap<Character, IState> map;


    /**
     * default constructor.
     * @param indent current indent
     *
     */
    StateMultilineComment(final int indent) {
        setIndent(indent);
        map = new HashMap<>();
        map.put('*', new StateAsterisk(indent));
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
        if (map.containsKey(c)) {
            return map.get(c);
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
