package formatter;
/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Formatter from in to out.
     * @param in input text
     * @param out output text
     */
    void format(IReader in, IWriter out);
}
