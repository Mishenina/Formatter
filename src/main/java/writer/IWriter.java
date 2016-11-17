package writer;


/**
 * Writer interface.
 */
public interface IWriter {

    /**
     * write symbol to file.
     * @param c symbol
     * @throws WriterException exception
     */
    void write(char c) throws  WriterException;

    /**
     *  method closes the file.
     * @throws WriterException exception
     */
    void close() throws WriterException;


}
