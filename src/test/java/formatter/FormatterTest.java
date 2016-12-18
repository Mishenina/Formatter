package formatter;

import formatter.core.*;
import formatter.fileIO.FileReader;
import formatter.fileIO.FileWriter;
import formatter.formatterimplementation.Formatter;
import formatter.formatterimplementation.lexer.Lexer;
import formatter.stringIO.StrReader;
import formatter.stringIO.StrWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/*
import formatter.core.FormatterException;
import formatter.core.IReader;
import formatter.core.ReaderException;
import formatter.core.WriterException;
import formatter.core.IWriter;
import formatter.core.IFormatter;
import formatter.formatterimplementation.lexer.Lexer;
 */

/**
 * Test for Formatter.
 */
public class FormatterTest {

    private IFormatter formatter;
    private IReader in;
    private IWriter out;
    private IReader lexer;
    private String check;

    /**
     * called before the test.
     *
     * @throws ReaderException exception reader
     * @throws WriterException exception writer
     */
    @Before
    public void setUp() throws ReaderException, WriterException {

        formatter = new Formatter();
    }

    /**
     * test read and write to file.
     * @throws FormatterException exception
     * @throws ReaderException exception
     * @throws WriterException exception
     * @throws IOException exception
     */
    @Test
    public void testReadAndWriteFile() throws FormatterException, ReaderException, WriterException, IOException {

        in = new FileReader("src/test/resources/input");
        out = new FileWriter("src/test/resources/output");
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
    /**
     * test method for brace.
     *
     * @throws FormatterException exception
     */
    @Test
    public void testBrace() throws FormatterException {

        in = new StrReader("test{test;}");
        out = new StrWriter();
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
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
        lexer = new Lexer(in);
        formatter.format(lexer, out);
        check = "for (int i = 0; i < n; i++)";
        assertEquals(check, out.toString());
    }

}

