package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 * symbol interface.
 */
public interface IToken {

    /**
     *  method for processing a symbol.
     * @param token input symbol
     * @param state current style format
     * @param out output stream
     * @throws WriterException exception writer
     */
    void processToken(String token, IState state, IWriter out) throws WriterException;

}

