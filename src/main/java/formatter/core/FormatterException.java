package formatter.core;

/**
 * Formatter exception.
 */
public class FormatterException extends Exception {
    /**
     * Formatter exception.
     *
     * @param message message
     * @param cause   exception
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
