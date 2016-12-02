package StringIO;


import Core.IReader;
import Core.ReaderException;

import java.io.StringReader;

/**
 * reader string.
 */
public class StrReader  implements IReader {
    /**
     * string reader.
     */
    private StringReader reader;

    /**
     * default constructor.
     *
     * @param str input sting
     */
    public StrReader(final String str) {
        reader = new StringReader(str);
    }

    /**
     * read char.
     *
     * @return next char
     * @throws ReaderException exception
     */
    public final char readChar() throws ReaderException {
        try {
            return (char) reader.read();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    /**
     * method read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    public final boolean ready() throws ReaderException {
        try {
            reader.mark(1);
            char result = (char) reader.read();
            reader.reset();
            return result < Character.MAX_VALUE;
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    /**
     * method closes.
     * @throws ReaderException exception
     */
    public final void close() throws ReaderException {
        try {
            reader.close();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

}
