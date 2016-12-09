package formatter.fileIO;


import java.io.BufferedWriter;
import formatter.core.IWriter;
import formatter.core.WriterException;

/**
 * Writer to write to string.
 */
public class FileWriter implements IWriter {

    /**
     * Buffer writer.
     */
    private BufferedWriter writer;

    /**
     * write symbol to file.
     *
     * @param str string
     * @throws WriterException exception
     */
    public final void write(final String str) throws WriterException {

        try {
            writer.write(str);
        } catch (Exception e) {
            throw new WriterException("writer failed", e);
        }
    }

    /**
     * method closes the file.
     *
     * @throws WriterException exception
     */
    public final void close() throws WriterException {
        try {
            writer.close();
        } catch (Exception e) {
            throw new WriterException("writer failed", e);
        }
    }


    /**
     * default constructor.
     * @param fileName path to the file
     * @throws WriterException Exception
     */
    public FileWriter(final String fileName) throws WriterException {
        try {
            writer = new BufferedWriter(new java.io.FileWriter(fileName));
        } catch (Exception e) {
            throw new WriterException("writer failed", e);
        }
    }

}
