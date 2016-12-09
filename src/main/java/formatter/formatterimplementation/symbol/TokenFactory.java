package formatter.formatterimplementation.symbol;


import formatter.formatterimplementation.state.IState;
import formatter.formatterimplementation.state.StateDefault;

import java.util.HashMap;

/**
 * object class selection.
 */
public class TokenFactory {

    /**
     * control symbols map.
     */
    private static HashMap<Character, IToken> map = new HashMap<>();

    /**
     * selection class.
     *
     * @param token      type input symbol
     * @param currentState current state
     * @return create object
     */
    public static IToken getToken(final String token, final IState currentState) {

        if (map.containsKey(token)  && currentState instanceof StateDefault) {
            return map.get(token);
        } else {
            return new TokenOther();
        }
    }

    /**
     * default constructor.
     */
    public TokenFactory() {
        map.put('{', new TokenOpenBrace());
        map.put('}', new TokenCloseBrace());
        map.put(';', new TokenSemicolon());
        map.put('\n', new TokenNewLine());

    }

}
