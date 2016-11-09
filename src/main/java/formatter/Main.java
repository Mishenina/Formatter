package formatter;

import java.io.IOException;

/**
 * Main class.
 */
public final class Main {
    /**
     *main method.
     * @param args parameters
     * @throws Formatter.FormatterException exception
     * @throws IOException exception
     */
    public static void main(final String[] args)  throws IOException, Formatter.FormatterException {

        IReader in = new FileReader();
        IWriter out = new FileWriter();
        in.openFile("src/main/resources/input");
        out.openFile("src/main/resources/output");
        IFormatter formatter = new Formatter();
        formatter.format(in, out);
        in.closeFile();
        out.closeFile();
    }
    /**
     * default constructor.
     */
    private Main() {

    }

}
