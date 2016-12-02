package FormatterImplementation.State;

import java.util.HashMap;

/**
 * formatter state default.
 */
public class StateDefault implements IState {

    /**
     * control symbols map.
     */
    private HashMap<Character, IState> map;


    /**
     * default constructor.
     * @param indent current indent
     */
    public StateDefault(final int indent) {
        setIndent(indent);
        map = new HashMap<>();
        map.put('/', new StateSlash(indent));
        map.put('\"', new StateStringLiteral(indent));
        map.put('\'', new StateCharLiteral(indent));
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
    public final IState getNextState(final char c) {
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
