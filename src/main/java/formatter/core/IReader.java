package formatter.core;

/**
 * Reader to read chars from string.
 */
public interface IReader {

    /**
     *  read char from a file.
     * @return next char
     * @throws ReaderException exception
     */
    String read()  throws ReaderException;

    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    boolean ready() throws ReaderException;

    /**
     * repositions this stream to the position at the time the mark method was last called on this input stream.
     * @throws ReaderException exception
     */
    void reset() throws ReaderException;
    /**
     * method closes the file.
     * @throws ReaderException exception
     */
    void close() throws ReaderException;
}
