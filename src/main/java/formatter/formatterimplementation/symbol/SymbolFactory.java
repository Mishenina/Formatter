package formatter.formatterimplementation.symbol;


import formatter.formatterimplementation.state.IState;
import formatter.formatterimplementation.state.StateDefault;

import java.util.HashMap;

/**
 * object class selection.
 */
public class SymbolFactory {

    /**
     * default constructor.
     */
    public SymbolFactory() {
        map.put("{", new SymbolOpenBrace());
        map.put("}", new SymbolCloseBrace());
        map.put(";", new SymbolSemicolon());
        map.put("\n", new SymbolNewLine());

    }


    /**
     * control symbols map.
     */
    private static HashMap<String, ISymbol> map = new HashMap<>();

    /**
     * selection class.
     *
     * @param token      type input symbol
     * @param currentState current state
     * @return create object
     */
    public static ISymbol getToken(final String token, final IState currentState) {

        if (map.containsKey(token)  && currentState instanceof StateDefault) {
            return map.get(token);
        } else {
            return new SymbolOther();
        }
    }

}
