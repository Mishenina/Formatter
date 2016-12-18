package formatter.formatterimplementation.state;

import java.util.HashMap;

/**
 * Created by anna on 06.12.16.
 */
public class NextState {

    private HashMap<Current, IState> map;

    /**
     * default constructor.
     */
    private class Current {
        private String nextSymbol;
        private IState currentState;

        Current(final String nextSymbol, final IState currentState) {
            this.nextSymbol = nextSymbol;
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
     * @param c current char
     * @param currentState current state
     * @return next state
     */
    public IState getNextState(final String c, final IState currentState) {
        Current test = new Current(c, currentState);
        Current q = new Current("default", currentState);
        if (map.containsKey(test)) {
            return map.get(test);
        } else {
            return map.get(q); //new StateMultilineComment(indent);
        }
    }
}
