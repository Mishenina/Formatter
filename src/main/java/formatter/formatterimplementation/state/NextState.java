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
     *
     */
    public NextState() {
        map = new HashMap<>();


        map.put(new Current("/*", new StateDefault()), new StateMultilineComment());
        map.put(new Current("//", new StateDefault()), new StateOnelineComment());
        map.put(new Current("\"", new StateDefault()), new StateStringLiteral());
        map.put(new Current("\'", new StateDefault()), new StateCharLiteral());
        map.put(new Current("for", new StateDefault()), new StateFor());
        map.put(new Current("default", new StateDefault()), new StateDefault());

        map.put(new Current("\'", new StateCharLiteral()), new StateDefault());
        map.put(new Current("default", new StateCharLiteral()), new StateCharLiteral());

        map.put(new Current(")", new StateFor()), new StateDefault());
        map.put(new Current("default", new StateFor()), new StateFor());


        map.put(new Current("\'", new StateCharLiteral()), new StateDefault());
        map.put(new Current("default", new StateCharLiteral()), new StateCharLiteral());

        map.put(new Current("*/", new StateMultilineComment()), new StateDefault());
        map.put(new Current("default", new StateMultilineComment()), new StateMultilineComment());

        map.put(new Current("\n", new StateOnelineComment()), new StateDefault());
        map.put(new Current("default", new StateOnelineComment()), new StateOnelineComment());

        map.put(new Current("\"", new StateStringLiteral()), new StateDefault());
        map.put(new Current("default", new StateStringLiteral()), new StateStringLiteral());

    }


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
