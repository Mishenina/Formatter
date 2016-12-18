package formatter.formatterimplementation.lexer;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.util.ArrayList;

/**
 * Read tokens.
 */
public class Lexer implements IReader {

    /**
     * input stream.
     */
    private IReader in;
    /**
     * next lexeme.
     */
    private StringBuilder nextLexeme = new StringBuilder();
    /**
     * array tokens.
     */
    private ArrayList<String> tokens = new ArrayList<>();

    /**
     * default constructor.
     * @param in input stream
     */
    public Lexer(final IReader in) {
        this.in = in;
        tokens.add("for");
        tokens.add("(");
        tokens.add(")");
        tokens.add(" ");
        tokens.add("\n");
        tokens.add(";");
        tokens.add("{");
        tokens.add("}");
        tokens.add("/*");
        tokens.add("*/");
        tokens.add("//");
        tokens.add("\"");
        tokens.add("\'");
    }

    /**
     * read lexeme.
     * @return lexeme
     * @throws ReaderException exception
     */
    public final String read() throws ReaderException {
        if (tokens.contains(nextLexeme.toString())) {
            String str = nextLexeme.toString();
            nextLexeme = new StringBuilder();
            return str;
        }
        nextLexeme = new StringBuilder();
        StringBuilder lexeme = new StringBuilder();
        while (in.ready()) {
            String current = in.read();
            if (tokens.contains(current) || tokens.contains(lexeme.toString())) {
                if (lexeme.length() != 0) {
                    nextLexeme.append(current);
                    return lexeme.toString();
                }  else {
                    lexeme.append(current);
                }
                break;
            }   else {
                lexeme.append(current);
            }
        }
        return lexeme.toString();
    }
    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    public final boolean ready() throws ReaderException {
        return in.ready();
    }

    /**
     * repositions this stream to the position at the time the mark method
     * was last called on this input stream.
     * @throws ReaderException exception
     */
    public final void reset() throws ReaderException {
        in.reset();

    }
    /**
     * close the stream.
     * @throws ReaderException exception
     */
    public final void close() throws ReaderException {
        in.close();
    }
}
