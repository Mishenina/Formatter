package reader;

/**
 * Created by anna on 16.11.16.
 */
public class ReaderException extends Exception {
    /**
     * Reader exception.
     * @param s message
     * @param e exception
     */
    public ReaderException(final String s, final Exception e) {
        super(s, e);
    }
}

