package FormatterImplementation.Symbol;


import FormatterImplementation.State.IState;
import FormatterImplementation.State.StateDefault;

import java.util.HashMap;

/**
 * object class selection.
 */
public class SymbolFactory {

    /**
     * control symbols map.
     */
    private static HashMap<Character, ISymbol> map = new HashMap<>();

    /**
     * selection class.
     *
     * @param symbol       type input symbol
     * @param currentState current state
     * @return create object
     */
    public static ISymbol getSymbol(final char symbol, final IState currentState) {

        if (map.containsKey(symbol)  && currentState instanceof StateDefault) {
            return map.get(symbol);
        } else {
            return new SymbolOther();
        }
    }

    /**
     * default constructor.
     */
    public SymbolFactory() {
        map.put('{', new SymbolOpenBrace());
        map.put('}', new SymbolCloseBrace());
        map.put(';', new SymbolSemicolon());
        map.put('\n', new SymbolNewLine());

    }

}
