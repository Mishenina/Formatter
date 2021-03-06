package formatter.fileIO;


import java.io.BufferedReader;

import formatter.core.IReader;
import formatter.core.ReaderException;


/**
 * Reader to read chars from string.
 */
public class FileReader implements IReader {

    /**
     * Buffer reader.
     */
    private BufferedReader bufReader;

    /**
     * read char from a file.
     *
     * @return next char
     * @throws ReaderException exception
     */
    public final String read() throws ReaderException {
        try {
            bufReader.mark(1);
            return String.valueOf((char) bufReader.read());
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    /**
     * method informs whether the stream is ready to be read.
     *
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    public final boolean ready() throws ReaderException {
        try {

            return bufReader.ready();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    /**
     * repositions this stream to the position at the time the mark method
     * was last called on this input stream.
     * @throws ReaderException exception
     */
    public final void reset() throws ReaderException {
        try {
            bufReader.reset();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    /**
     * method closes the file.
     *
     * @throws ReaderException exception
     */
    public final void close() throws ReaderException {
        try {

            bufReader.close();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }


    /**
     *  default constructor.
     * @param fileName path to the file
     * @throws ReaderException exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            bufReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }

    }
}
