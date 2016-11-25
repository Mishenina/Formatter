package Core;;

/**
 * Reader interface.
 */
public interface IReader {

    /**
     *  read char from a file.
     * @return next char
     * @throws ReaderException exception
     */
    char readChar()  throws ReaderException;

    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    boolean ready() throws ReaderException;

    /**
     * method closes the file.
     * @throws ReaderException exception
     */
    void close() throws ReaderException;
}
