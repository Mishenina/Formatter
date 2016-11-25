package Core;

/**
 * writer exception.
 */
public class WriterException extends Exception {
    /**
     * Writer exception.
     * @param s message
     * @param e exception
     */
    public WriterException(final String s, final Exception e) {
        super(s, e);
    }
}
