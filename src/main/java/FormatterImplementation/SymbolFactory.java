package FormatterImplementation;


/**
 * object class selection.
 */
class SymbolFactory {

/*    private static Map<Character, ISymbol> map = new HashMap<Character, ISymbol>();
           static ISymbol getSymbol(final char symbol, IState currentState) {

            if (map.containsKey(symbol) && currentState instanceof StateDefault) {
                 return map.get(symbol);
             }   else {
                 return new SymbolOther();
             }*/


    /**
     *  selection class.
     * @param type type input symbol
     * @param currentState current state
     * @return create object
     */
    static ISymbol getSymbol(final char type, final IState currentState) {
        ISymbol symbol;
        if (type == ';' && currentState instanceof StateDefault) {
            symbol = new SymbolSemicolon();
        } else if (type == '{' && currentState instanceof StateDefault) {
            symbol = new SymbolOpenBrace();
        } else if (type == '}' && currentState instanceof StateDefault) {
            symbol = new SymbolCloseBrace();
        } else if (type == '\n') {
            symbol = new SymbolNewLine();
        } else {
            symbol = new SymbolOther();
        }

        return symbol;
    }


    /**
     * default constructor.
     */
     public SymbolFactory() {
           /*map.put('{', new SymbolOpenBrace());
           map.put('}', new SymbolCloseBrace());
           map.put(';', new SymbolSemicolon());
           map.put('\n', new SymbolNewLine());
           */
    }

}