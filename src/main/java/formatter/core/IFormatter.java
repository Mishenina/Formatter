package formatter.core;

/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Formatter from in to out.
     *
     * @param in  input text
     * @param out output text
     * @throws FormatterException exception
     */
    void format(IReader in, IWriter out) throws FormatterException;

}
