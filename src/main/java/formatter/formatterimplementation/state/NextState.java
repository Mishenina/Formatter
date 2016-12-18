package formatter.formatterimplementation.state;

import java.util.HashMap;

/**
 * selection of the next state.
 */
public class NextState {
    /**
     * Map current token, current state and next state.
     */
    private HashMap<Current, IState> map;

    /**
     * default constructor.
     */
    private class Current {
        /**
         * current token.
         */
        private String token;
        /**
         * current state.
         */
        private IState currentState;

        /**
         *  default constructor.
         * @param token current token
         * @param currentState current state
         */
        Current(final String token, final IState currentState) {
            this.token = token;
            this.currentState = currentState;
        }
    }
    /**
     * default constructor.
     * @param indent current indent
     *
     */
    public NextState(final int indent) {
        map = new HashMap<>();
        this.indent = indent;


        map.put(new Current("/*", new StateDefault(indent)), new StateMultilineComment(indent));
        map.put(new Current("//", new StateDefault(indent)), new StateOnelineComment(indent));
        map.put(new Current("\"", new StateDefault(indent)), new StateStringLiteral(indent));
        map.put(new Current("\'", new StateDefault(indent)), new StateCharLiteral(indent));
        map.put(new Current("for", new StateDefault(indent)), new StateFor(indent));
        map.put(new Current("default", new StateDefault(indent)), new StateDefault(indent));

        map.put(new Current("\'", new StateCharLiteral(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateCharLiteral(indent)), new StateCharLiteral(indent));

        map.put(new Current(")", new StateFor(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateFor(indent)), new StateFor(indent));


        map.put(new Current("\'", new StateCharLiteral(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateCharLiteral(indent)), new StateCharLiteral(indent));

        map.put(new Current("*/", new StateMultilineComment(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateMultilineComment(indent)), new StateMultilineComment(indent));

        map.put(new Current("\n", new StateOnelineComment(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateOnelineComment(indent)), new StateOnelineComment(indent));

        map.put(new Current("\"", new StateStringLiteral(indent)), new StateDefault(indent));
        map.put(new Current("default", new StateStringLiteral(indent)), new StateStringLiteral(indent));

    }


    /**
     * indent.
     */
    private int indent;


    /**
     * determine next state.
     * @param token current token
     * @param currentState current state
     * @return next state
     */
    public final IState getNextState(final String token, final IState currentState) {
        Current currentS = new Current(token, currentState);
        Current defaultS = new Current("default", currentState);
        if (map.containsKey(currentS)) {
            return map.get(currentS);
        } else {
            return map.get(defaultS);
        }
    }
}
