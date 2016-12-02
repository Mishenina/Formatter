package FormatterImplementation.Symbol;

import Core.IWriter;
import Core.WriterException;
import FormatterImplementation.State.IState;

/**
 * symbol interface.
 */
public interface ISymbol {

    /**
     *  method for processing a symbol.
     * @param c input symbol
     * @param state current style format
     * @param out output stream
     * @throws WriterException exception writer
     */
    void processSymbol(char c, IState state, IWriter out) throws WriterException;

}

