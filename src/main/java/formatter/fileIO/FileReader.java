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
    private BufferedReader bufferedReader;

    /**
     * read char from a file.
     *
     * @return next char
     * @throws ReaderException exception
     */
    public final Object read() throws ReaderException {
        try {
            bufferedReader.mark(1);
            return (char) bufferedReader.read();
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

            return bufferedReader.ready();
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }
    }

    public final void reset() throws ReaderException {
        try {
            bufferedReader.reset();
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

            bufferedReader.close();
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
            bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (Exception e) {
            throw new ReaderException("reader failed", e);
        }

    }
}
