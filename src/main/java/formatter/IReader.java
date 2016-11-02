package formatter;

//package formatter;

/**
 * Reader interface.
 */
public interface IReader {

    /**
     * read from a file.
     * @param fileName file name
     * @return StringBuilder input text
     */
    StringBuilder read(String fileName);
}
