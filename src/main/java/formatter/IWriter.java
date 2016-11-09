package formatter;

import java.io.IOException;

/**
 * Writer interface.
 */
public interface IWriter {

    /**
     * method open the file.
     * @param fileName file name
     * @throws IOException exception
     */
    void openFile(String fileName) throws IOException;

    /**
     * write symbol to file.
     * @param c symbol
     * @throws IOException exception
     */
    void write(char c) throws IOException;

    /**
     *  method closes the file.
     * @throws IOException exception
     */
    void closeFile() throws IOException;
}
