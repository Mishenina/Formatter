package FormatterImplementation.Symbol;

import Core.IWriter;
import Core.WriterException;
import FormatterImplementation.State.IState;

/**
 *Symbol other.
 */
class SymbolOther implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param c     input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processSymbol(final char c, final IState state, final IWriter out) throws WriterException {
        out.write(String.valueOf(c));

    }

}

