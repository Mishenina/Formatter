package formatter.formatterimplementation;


import formatter.core.IReader;
import formatter.core.IFormatter;
import formatter.core.FormatterException;
import formatter.core.IWriter;
import formatter.formatterimplementation.state.IState;
import formatter.formatterimplementation.symbol.IToken;
import formatter.formatterimplementation.symbol.TokenFactory;
import formatter.formatterimplementation.state.StateDefault;

/**
 * Formatter from in to out.
 */
public class Formatter implements IFormatter {
    /**
     * text formatting.
     *
     * @param in  input text
     * @param out output text
     * @throws FormatterException when formatting failed
     */
    public final void format(final IReader in, final IWriter out) throws FormatterException {

        try {
            IState currentState = new StateDefault(0);
            TokenFactory factory = new TokenFactory();
            IReader lexer = new Lexer(in);
            while (lexer.ready()) {
                String token = in.read().toString();
                IToken s = factory.getToken(token, currentState);
                s.processToken(token, currentState, out);
                currentState = currentState.getNextState(token);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }
}
