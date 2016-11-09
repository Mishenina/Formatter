package formatter;

import java.io.IOException;

/**
 * Reader interface.
 */
public interface IReader {

    /**
     *  read char from a file.
     * @return next char
     * @throws IOException exception
     */
    char readChar()  throws IOException;
    /**
     * open a file.
     * @param fileName File name
     * @throws IOException Exception
     */
    void openFile(String fileName) throws IOException;
    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws IOException exception
     */
    boolean ready() throws IOException;
    /**
     * method closes the file.
     * @throws IOException exception
     */
    void closeFile() throws IOException;

}
