package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.Indent;

/**
 * symbol close round brace.
 */
public class SymbolCloseRoundBrace implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param symbol input symbol
     * @param  indent current indent
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processSymbol(final String symbol, final Indent indent, final IWriter out) throws WriterException {
        out.write(")");
    }

}
