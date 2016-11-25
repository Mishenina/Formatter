package FormatterImplementation;

import Core.IWriter;
import Core.WriterException;

/**
 * symbol interface.
 */
interface ISymbol {

    /**
     *  method for processing a symbol.
     * @param c input symbol
     * @param state current style format
     * @param out output stream
     * @throws WriterException exception writer
     */
    void processSymbol(char c, IState state, final IWriter out) throws WriterException;

}

