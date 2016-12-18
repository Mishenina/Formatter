package formatter.formatterimplementation.symbol;

import formatter.core.IWriter;
import formatter.core.WriterException;
import formatter.formatterimplementation.state.IState;

/**
 * Created by anna on 09.12.16.
 */
public class SymbolOpenRoundBrace implements ISymbol {

        /**
         * method for processing a symbol.
         *
         * @param token     input symbol
         * @param state current style format
         * @param out   output stream
         * @throws WriterException exception writer
         */
        public void processToken(final String token, final IState state, final IWriter out) throws WriterException {
            out.write("(");
        }

    }
