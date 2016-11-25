package formatter;

import Core.*;
import StringIO.StrReader;
import StringIO.StrWriter;
import org.junit.Before;
import org.junit.Test;
import FormatterImplementation.Formatter;

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
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Test
    public void testBrace() throws FormatterException, ReaderException, WriterException {

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
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Test
    public void testMultilineComment() throws FormatterException, ReaderException, WriterException {

        in = new StrReader("test/*test;*/");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test/*test;*/";
        assertEquals(check, out.toString());
    }

    /**
     * test method for symbol new line.
     * @throws FormatterException exception formatter
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Test
    public void testNewLine() throws FormatterException, ReaderException, WriterException {

        in = new StrReader("test\n");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test\n";
        assertEquals(check, out.toString());
    }

    /**
     * test method for string literal.
     * @throws FormatterException exception formatter
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */

    @Test
    public void testStringLiteral() throws FormatterException, ReaderException, WriterException {

        in = new StrReader("test\"test;\n\"");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test\"test;\n\"";
        assertEquals(check, out.toString());
    }

    /**
     * test method for char literal.
     * @throws FormatterException exception formatter
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */

    @Test
    public void testCharLiteral() throws FormatterException, ReaderException, WriterException {

        in = new StrReader("test\'\n\'test;");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test\'\n\'test;";
        assertEquals(check, out.toString());
    }

    /**
     * test method for comment.
     * @throws FormatterException exception formatter
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Test
    public void testComment() throws FormatterException, ReaderException, WriterException {

        in = new StrReader("test//test;{}");
        out = new StrWriter();
        formatter.format(in, out);
        check = "test//test;{}";
        assertEquals(check, out.toString());
    }

}

