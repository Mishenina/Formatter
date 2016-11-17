package formatter;

import org.junit.Before;
import org.junit.Test;
import reader.IReader;
import reader.ReaderException;
import reader.StrReader;
import reader.FileReader;
import writer.FileWriter;
import writer.IWriter;
import writer.StrWriter;
import writer.WriterException;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test for Formatter.
 */
public class FormatterTest {

    private IFormatter formatter;
    private IReader in;
    private IWriter out;
    private String check;

    /**
     *  called before the test.
     * @throws ReaderException exception
     * @throws WriterException exception
     */
    @Before
    public void serUp() throws ReaderException, WriterException {

        formatter = new Formatter();
     /*   in = new StrReader("text;text{text{{{{text;text;\n" +
                "text;text}text;  }text;text;//text;text;text\n" +
                "text;text;\n");
        out = new StrWriter();
        check ="text;\n" +
                "text {\n" +
                "    text{{{{text;text;\n" +
                "\n" +
                "text;text}text; \n" +
                "}\n" +
                "text;\n" +
                "text;\n" +
                "//text;text;text\n" +
                "\n" +
                "text;\n" +
                "text;\n" +
                "\n" +
                "\n";*/
        in = new FileReader("src/test/resources/input");
        out = new FileWriter("src/test/resources/output");
    }

    /**
     * test method.
     *
     * @throws Formatter.FormatterException exception
     * @ReaderException exception
     * @WriterException exception
     * @throws IOException                  exception
     */
    @Test
    public void testFormatter() throws Formatter.FormatterException, ReaderException, WriterException, IOException {
      /*  formatter.format(in, out);

        assertEquals(check, out.toString());
        in.close();
        out.close();
        */
        formatter.format(in, out);
        in.close();
        out.close();

        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader("src/test/resources/outputcheck"));
        StringBuilder outputcheck = new StringBuilder();
        int symbol = bufferedReader.read();
        while (symbol != -1) {
            symbol = bufferedReader.read();
            outputcheck.append((char) symbol);
        }

        bufferedReader = new BufferedReader(new java.io.FileReader("src/test/resources/output"));
        StringBuilder output = new StringBuilder();
        symbol = bufferedReader.read();
        while (symbol != -1) {
            symbol = bufferedReader.read();
            output.append((char) symbol);
        }

        assertEquals(outputcheck.toString(), output.toString());


    }
}

