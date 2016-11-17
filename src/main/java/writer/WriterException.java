package writer;

/**
 * Created by anna on 17.11.16.
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
