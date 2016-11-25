package FormatterImplementation;

import Core.IWriter;
import Core.WriterException;

/**
 * Symbol close brace.
 */
class SymbolCloseBrace implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param c     input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processSymbol(final char c, final IState state, final IWriter out) throws WriterException {

        out.write("\n");
        int indent = state.getIndent() - 1;
        state.setIndent(indent);
        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }
        out.write(String.valueOf(c));
        out.write("\n");

        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }

    }

}