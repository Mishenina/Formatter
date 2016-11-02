package formatter;

/**
 * Main class.
 */
public final class Main {
    /**
     *main method.
     * @param args parameters
     */
    public static void main(final String[] args) {

        IReader in = new StringReader();
        IWriter out = new StringWriter();
        IFormatter formatter = new Formatter();
        formatter.format(in, out);
    }
    /**
     * default constructor.
     */
    private Main() {

    }

}
