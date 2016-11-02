package formattertest;

import formatter.Formatter;
import formatter.IFormatter;
import formatter.IReader;
import formatter.IWriter;
import formatter.StringReader;
import formatter.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for Formatter.
 */
public class FormatterTest {

    private  IFormatter formatter;

    /**
     * called before the test.
     */
    @Before
    public void serUp() {

        formatter = new Formatter();
    }

    /**
     * test method.
     */
    @Test
    public void testCopy() {
        IReader in = new StringReader();
        IWriter out = new StringWriter();

        IReader outTest = new StringReader();
        StringBuilder outStrTest = outTest.read("src/test/resources/outTest");

        formatter.format(in, out);

        IReader outFormatterTest = new StringReader();
        StringBuilder outFormatterStrTest = outFormatterTest.read("src/main/resources/output");

        assertEquals(outStrTest.toString(), outFormatterStrTest.toString());
    }
}

