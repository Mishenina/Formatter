package formatter;

import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.core.WriterException;
import formatter.core.IWriter;
import formatter.core.IFormatter;
import formatter.stringIO.StrReader;
import formatter.stringIO.StrWriter;
import org.junit.Before;
import org.junit.Test;
import formatter.formatterimplementation.Formatter;

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
     * called before the test.
     *
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Before
    public void serUp() throws ReaderException, WriterException {

        formatter = new Formatter();
    }

    /**
     * test method for brace.
     *
     * @throws FormatterException exception
     */
    @Test
    public void testBrace() throws FormatterException {

        in = new StrReader("test{test;}");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test {\n" +
                "\ttest;\n" +
                "\t\n" +
                "}\n";
        assertEquals(check, out.toString());
    }

    /**
     * test method for multiline comment.
     *
     * @throws FormatterException exception
     */
    @Test
    public void testMultilineComment() throws FormatterException {

        in = new StrReader("test/*test;*/");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test/*test;*/";
        assertEquals(check, out.toString());
    }

    /**
     * test method for symbol new line.
     * @throws FormatterException exception formatter
     */
    @Test
    public void testNewLine() throws FormatterException {

        in = new StrReader("test\n");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test\n";
        assertEquals(check, out.toString());
    }

    /**
     * test method for string literal.
     * @throws FormatterException exception formatter
     */

    @Test
    public void testStringLiteral() throws FormatterException {

        in = new StrReader("test\"test;\"");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test\"test;\"";
        assertEquals(check, out.toString());
    }

    /**
     * test method for char literal.
     * @throws FormatterException exception formatter
     */

    @Test
    public void testCharLiteral() throws FormatterException {

        in = new StrReader("test'{'test");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test'{'test";
        assertEquals(check, out.toString());
    }

    /**
     * test method for comment.
     * @throws FormatterException exception formatter
     */
    @Test
    public void testComment() throws FormatterException {

        in = new StrReader("test//test;{}");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test//test;{}";
        assertEquals(check, out.toString());
    }
    /**
     * test method for loop.
     * @throws FormatterException exception formatter
     */
    @Test
    public void testFor() throws FormatterException {
        in = new StrReader("for (int i = 0; i < n; i++)");
        out = new StrWriter();
        formatter.format(in, out);
        check = "for (int i = 0; i < n; i++)";
        assertEquals(check, out.toString());
    }

}

