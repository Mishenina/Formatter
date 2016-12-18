package formatter.formatterimplementation;

import formatter.core.IReader;
import formatter.core.ReaderException;

import java.util.ArrayList;

/**
 * Read tokens.
 */
class Lexer implements IReader {
    private IReader in;
    private StringBuilder lexeme = new StringBuilder();
    private ArrayList<String> tokens = new ArrayList<>();
    private String next;

    /**
     * default constructor.
     * @param in input stream
     */
    Lexer(final IReader in) {
        this.in = in;
      //  tokens.add("for");
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
    //множество разделителей
    //когда встретили разделитель, то возвращаем лексему, а разделитель запоминаем
    // на след шаге записываем прошлый разделитель в лексему
    //если такая лексема есть, то возвращаем
    //лексер неправильный
    //состояние становится null
    //
    /**
     * read lexeme.
     * @return lexeme
     * @throws ReaderException exception
     */
    public String read() throws ReaderException {
        lexeme = new StringBuilder();
      // if (next !=null) {
    //       lexeme.append(next);
    //   }
        while (in.ready()) {
           String q  = in.read();
                lexeme.append(q);
            if (tokens.contains(lexeme.toString())) {
                //next = q;
                break;
            }
        }
        return lexeme.toString();
    }
    /**
     * method informs whether the stream is ready to be read.
     * @return the method returns true if the stream is ready to be read
     * @throws ReaderException exception
     */
    public boolean ready() throws ReaderException {
        return in.ready();
    }

    /**
     * repositions this stream to the position at the time the mark method was last called on this input stream.
     * @throws ReaderException exception
     */
    public void reset() throws ReaderException {
        in.reset();

    }
    /**
     * close the stream.
     * @throws ReaderException exception
     */
    public void close() throws ReaderException {
        in.close();
    }
}
