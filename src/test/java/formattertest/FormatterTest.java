package formattertest;

import formatter.Formatter;
import formatter.IFormatter;
import formatter.IReader;
import formatter.IWriter;
import formatter.FileReader;
import formatter.FileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test for Formatter.
 */
public class FormatterTest {

    private  IFormatter formatter;
    private IReader in;
    private IWriter out;

    /**
     * called before the test.
     */
    @Before
    public void serUp() {

        formatter = new Formatter();
        in = new FileReader();
        out = new FileWriter();
    }

    /**
     * test method.
     * @throws Formatter.FormatterException exception
     * @throws IOException exception
     */
    @Test
    public void testCopy()  throws IOException, Formatter.FormatterException  {

        in.openFile("src/test/resources/input");
        out.openFile("src/test/resources/output");
        formatter.format(in, out);
        in.closeFile();
        out.closeFile();

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

