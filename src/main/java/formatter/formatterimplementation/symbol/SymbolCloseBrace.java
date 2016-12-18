package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 * symbol close brace.
 */
class SymbolCloseBrace implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param token     input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processToken(final String token, final IState state, final IWriter out) throws WriterException {

        out.write("(");
        int indent = state.getIndent() - 1;
        state.setIndent(indent);
        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }
        out.write(String.valueOf(token));
        out.write("\n");

        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }

    }

}
