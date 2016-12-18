package formatter.stringIO;


import formatter.core.IReader;
import formatter.core.ReaderException;

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
    public final String read() throws ReaderException {
        try {
            reader.mark(1);
            return  String.valueOf((char) reader.read());
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
     * repositions this stream to the position at the time the mark method was last called on this input stream.
     * @throws ReaderException exception
     */
    public final void reset() throws ReaderException {
        try {
            reader.reset();
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
