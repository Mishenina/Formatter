package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.Indent;

/**
 * symbol interface.
 */
public interface ISymbol {

    /**
     *  method for processing a symbol.
     * @param symbol input symbol
     * @param indent current indent
     * @param out output stream
     * @throws WriterException exception writer
     */
    void processSymbol(String symbol, Indent indent, IWriter out) throws WriterException;

}

