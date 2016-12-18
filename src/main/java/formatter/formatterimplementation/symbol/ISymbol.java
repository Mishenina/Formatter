package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 * symbol interface.
 */
public interface ISymbol {

    /**
     *  method for processing a symbol.
     * @param symbol input symbol
     * @param state current style format
     * @param out output stream
     * @throws WriterException exception writer
     */
    void processSymbol(String symbol, IState state, IWriter out) throws WriterException;

}

