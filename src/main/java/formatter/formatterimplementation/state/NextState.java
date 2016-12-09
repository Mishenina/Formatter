package formatter.formatterimplementation.state;

import java.util.HashMap;

/**
 * Created by anna on 06.12.16.
 */
public class NextState {

    private HashMap<Current, IState> map;

    private class Current {

        private String nextSymbol;
        private IState currentState;

        Current(String nextSymbol, IState currentState) {
            this.nextSymbol = nextSymbol;
            this.currentState = currentState;
        }
    }
    /**
     * default constructor.
     * @param indent current indent
     *
     */
    NextState(final int indent) {
        map = new HashMap<>();
        this.indent = indent;


        map.put(new Current("/*", new StateDefault(indent)), new StateMultilineComment(indent));
        map.put(new Current("//", new StateDefault(indent)), new StateOnelineComment(indent));
        map.put(new Current("\"", new StateDefault(indent)), new StateStringLiteral(indent));
        map.put(new Current("\'", new StateDefault(indent)), new StateCharLiteral(indent));
        map.put(new Current("for", new StateDefault(indent)), new StateFor(indent));
        map.put(new Current('любой другой', new StateDefault(indent)), new StateDefault(indent));

        map.put(new Current("\'", new StateCharLiteral(indent)), new StateDefault(indent));

        map.put(new Current(")", new StateFor(indent)), new StateDefault(indent));


        map.put(new Current("\'", new StateCharLiteral(indent)), new StateDefault(indent));
        map.put(new Current('любой другой', new StateCharLiteral(indent)), new StateCharLiteral(indent));

        map.put(new Current('любой другой', new StateMultilineComment(indent)), new StateMultilineComment(indent));

        map.put(new Current("\n", new StateOnelineComment(indent)), new StateDefault(indent));
        map.put(new Current('любой другой', new StateOnelineComment(indent)), new StateOnelineComment(indent));

        map.put(new Current("\"", new StateStringLiteral(indent)), new StateDefault(indent));
        map.put(new Current('любой другой', new StateStringLiteral(indent)), new StateStringLiteral(indent));

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
    public IState getNextState(final String c, IState currentState) {
        Current с = new Current(c, currentState);
        if (map.containsKey(c)) {
            return map.get(c);
        } else {
            return new StateMultilineComment(indent);
        }
    }
}
