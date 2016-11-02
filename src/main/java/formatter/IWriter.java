package formatter;

/**
 * Writer interface.
 */
public interface IWriter {
    /**
     * write to file.
     * @param fileName file name
     * @param text source text
     */
   void write(String fileName, StringBuilder text);
}
