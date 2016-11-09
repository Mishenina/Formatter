package formatter;


import java.io.BufferedReader;
import java.io.IOException;

/**
 * Reader to read chars from string.
 */
public class FileReader implements IReader {

    /**
     * Buffer reader.
     */
    private static BufferedReader bufferedReader;

    /**
     * open a file.
     * @param fileName File name
     * @throws IOException Exception
     */
    public final void openFile(final String fileName) throws IOException {
        bufferedReader   = new BufferedReader(new java.io.FileReader(fileName));
    }

    /**
     *  read char from a file.
     * @return next char
     * @throws IOException exception
     */
    public final char readChar()  throws IOException {

        return (char) bufferedReader.read();
    }

    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws IOException exception
     */
    public final boolean ready()  throws IOException {
        return bufferedReader.ready();
    }

    /**
     * method closes the file.
     * @throws IOException exception
     */
    public final void closeFile() throws IOException {
        bufferedReader.close();
    }


    /**
     * default constructor.
     */
    public FileReader()  {

    }
}
