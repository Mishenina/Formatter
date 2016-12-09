package formatter.formatterimplementation;



import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.core.WriterException;
import formatter.core.IWriter;
import formatter.core.IFormatter;
import formatter.fileIO.FileReader;
import formatter.fileIO.FileWriter;

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
            IReader in = new FileReader(args[0]);
            IWriter out = new FileWriter(args[1]);

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
