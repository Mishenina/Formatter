package FormatterImplementation;



import Core.FormatterException;
import Core.IReader;
import Core.ReaderException;
import Core.WriterException;
import Core.IWriter;
import Core.IFormatter;
import FileIO.FileReader;
import FileIO.FileWriter;

/**
 * Main class.
 */
public final class Main {

    /**
     * main method.
     *
     * @param args parameters
     * @throws FormatterException Exception
     * @throws ReaderException              Exception
     * @throws WriterException              Exception
     */
    public static void main(final String[] args) throws FormatterException, ReaderException, WriterException {
        try {
            IReader in = new FileReader("src/main/resources/input");
            IWriter out = new FileWriter("src/main/resources/output");

            IFormatter formatter = new Formatter();
            formatter.format(in, out);
            in.close();
            out.close();
        } catch (FormatterException e) {
            throw new ReaderException("formatter failed", e);
        } catch (ReaderException e) {
            throw new ReaderException("reader failed", e);
        } catch (WriterException e) {
            throw new WriterException("writer failed", e);
        }
    }

    /**
     * default constructor.
     */
    private Main() {

    }

}
