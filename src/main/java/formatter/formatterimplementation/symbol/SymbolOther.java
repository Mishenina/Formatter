package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 *symbol other.
 */
class SymbolOther implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param token     input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processToken(final String token, final IState state, final IWriter out) throws WriterException {
        out.write(String.valueOf(token));

    }

}

