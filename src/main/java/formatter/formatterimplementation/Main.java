package formatter.formatterimplementation;



import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.core.WriterException;
import formatter.core.IWriter;
import formatter.core.IFormatter;
import formatter.fileIO.FileReader;
import formatter.fileIO.FileWriter;
import formatter.formatterimplementation.lexer.Lexer;

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
            IReader lexer = new Lexer(in);
            IFormatter formatter = new Formatter();
            formatter.format(lexer, out);
            in.close();
            out.close();
        } catch (FormatterException e) {
            throw new FormatterException("formatter failed", e);
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
