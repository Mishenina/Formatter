package StringIO;


import Core.IWriter;
import Core.WriterException;

import java.io.StringWriter;

/**
 *writer string.
 */
public class StrWriter implements IWriter {
    /**
     * string writer
     */
    private StringWriter writer;

    /**
     *default constructor.
     */
    public StrWriter() {
        writer = new StringWriter();
    }

    /**
     * write char.
     * @param c symbol
     * @throws WriterException Exception
     */
    public final void write(final String c) throws WriterException {
        try {

        writer.write(c);
        } catch (Exception e) {
            throw new WriterException("writer failed", e);
        }

    }

    /**
     * method closes.
     * @throws WriterException Exception
     */
    public final void close() throws WriterException {
        try {
        writer.close();
        } catch (Exception e) {
            throw new WriterException("writer failed", e);
        }
    }

    /**
     * to string.
     * @return string
     */
    public final String toString() {
        return writer.toString();
    }


}
