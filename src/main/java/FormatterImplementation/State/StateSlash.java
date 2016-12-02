package FormatterImplementation.State;

import java.util.HashMap;

/**
 * stage formatter symbol slash.
 */
class StateSlash implements IState {

    /**
     *  control symbols map.
     */
    private HashMap<Character, IState> map;

    /**
     * default constructor.
     * @param indent current indent
     *
     */
    StateSlash(final int indent) {
        setIndent(indent);
        map = new HashMap<>();
        map.put('*', new StateMultilineComment(indent));
        map.put('/', new StateOnelineComment(indent));
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
            return new StateDefault(indent);
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
