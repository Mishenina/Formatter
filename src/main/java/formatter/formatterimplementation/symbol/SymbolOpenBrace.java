package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 * symbol open brace.
 */
class SymbolOpenBrace implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param symbol input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processSymbol(final String symbol, final IState state, final IWriter out) throws WriterException {
        out.write(" {\n");
        int indent = state.getIndent() + 1;
        state.setIndent(indent);
        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }
    }

}
