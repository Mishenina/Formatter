package formatter.formatterimplementation;


import formatter.core.IReader;
import formatter.core.IFormatter;
import formatter.core.FormatterException;
import formatter.core.IWriter;
import formatter.formatterimplementation.state.IState;
import formatter.formatterimplementation.state.NextState;
import formatter.formatterimplementation.symbol.ISymbol;
import formatter.formatterimplementation.symbol.SymbolFactory;
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
            SymbolFactory factory = new SymbolFactory();
            NextState nextState = new NextState(0);
            while (in.ready()) {
                String token = in.read();
                ISymbol s = factory.getToken(token, currentState);
                s.processSymbol(token, currentState, out);
                currentState = nextState.getNextState(token, currentState);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }
}
