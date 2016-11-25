package FormatterImplementation;


import Core.IWriter;
import Core.WriterException;

/**
 * method for formatting.
 */
class SymbolNewLine implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param c     input symbol
     * @param state current style format
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public void processSymbol(final char c, final IState state, final IWriter out) throws WriterException {
        out.write("\n");
        int indent = state.getIndent();
        for (int i = 0; i < indent; i++) {
            out.write("\t");
        }
    }

}
