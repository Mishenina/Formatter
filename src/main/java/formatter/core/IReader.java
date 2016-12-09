package formatter.core;;

/**
 * Reader interface.
 */
public interface IReader<T> {

    /**
     *  read char from a file.
     * @return next char
     * @throws ReaderException exception
     */
    T read()  throws ReaderException;

    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    boolean ready() throws ReaderException;

    void reset() throws ReaderException;
    /**
     * method closes the file.
     * @throws ReaderException exception
     */
    void close() throws ReaderException;
}
