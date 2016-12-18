package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.Indent;

/**
 * symbol open brace.
 */
class SymbolOpenBrace implements ISymbol {

    /**
     * method for processing a symbol.
     *
     * @param symbol input symbol
     * @param indent current indent
     * @param out   output stream
     * @throws WriterException exception writer
     */
    public final void processSymbol(final String symbol, final Indent indent, final IWriter out) throws WriterException {
        out.write(" {\n");
        indent.setIndent(indent.getIndent() + 1);
        for (int i = 0; i < indent.getIndent(); i++) {
            out.write("\t");
        }
    }

}
