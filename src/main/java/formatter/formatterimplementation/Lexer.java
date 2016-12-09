package formatter.formatterimplementation;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.util.ArrayList;

/**
 * Created by anna on 07.12.16.
 */
public class Lexer implements IReader {
    private IReader in;
    private StringBuilder lexeme = new StringBuilder();
    private ArrayList<String> tokens = new ArrayList();

    public Lexer(IReader in) {
        this.in = in;
        tokens.add("for");
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

    public String read() throws ReaderException {
        while (in.ready()) {
            lexeme.append(in.read());
            if(tokens.contains(lexeme)) {
                break;
            }
        }
        return lexeme.toString();
    }

    @Override
    public boolean ready() throws ReaderException {
        return false;
    }

    @Override
    public void reset() throws ReaderException {
        in.reset();

    }

    @Override
    public void close() throws ReaderException {

    }
}
