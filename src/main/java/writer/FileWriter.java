package writer;


import java.io.BufferedWriter;

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
     * @param c symbol
     * @throws WriterException exception
     */
    public final void write(final char c) throws WriterException {

        try {
            writer.write(c);
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
