package Core;

/**
 * reader exception.
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

