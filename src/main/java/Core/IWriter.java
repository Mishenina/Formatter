package Core;

/**
 * Writer interface.
 */
public interface IWriter {

    /**
     * write symbol to file.
     * @param str symbol
     * @throws WriterException exception
     */
    void write(String str) throws  WriterException;

    /**
     *  method closes the file.
     * @throws WriterException exception
     */
    void close() throws WriterException;

}
