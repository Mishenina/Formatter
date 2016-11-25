package FormatterImplementation;


import Core.IReader;
import Core.IFormatter;
import Core.FormatterException;
import Core.IWriter;

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
            IState currentState = new StateDefault();

            while (in.ready()) {
                char symbol = in.readChar();
                ISymbol s = SymbolFactory.getSymbol(symbol, currentState);
                s.processSymbol(symbol, currentState, out);
                currentState = currentState.getNextState(symbol);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }


    }
}