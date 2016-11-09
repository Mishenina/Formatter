package formatter;


import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Writer to write to string.
 */
public class FileWriter implements IWriter {

    /**
     *  Buffer writer.
     */
    private BufferedWriter writer;
    /**
     * method open the file.
     * @param fileName file name
     * @throws IOException exception
     */
    public final void openFile(final String fileName) throws IOException {
        writer = new BufferedWriter(new java.io.FileWriter(fileName));
    }
    /**
     * write symbol to file.
     * @param c symbol
     * @throws IOException exception
     */
    public final void write(final char c) throws IOException {

        writer.write(c);
    }
    /**
     *  method closes the file.
     * @throws IOException exception
     */
    public final void closeFile() throws IOException {
        writer.close();
    }
    /**
     * default constructor.
     */
    public FileWriter() {

    }
}
