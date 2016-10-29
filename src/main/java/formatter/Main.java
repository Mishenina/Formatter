package formatter;

import  java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by anna on 26.10.16.
 */
public final class Main {
    /**
     *main method.
     * @param args parameters
     */
    public static void main(final String[] args) {

    StringBuilder text;

    text = Main.read("src/main/resources/input");

    final int space = 4;
    int indent = 0;
    for (int i = 0; i < text.length(); i++) {
        switch (text.charAt(i)) {
            case ';':
                text.insert(i + 1, "\n");
                for (int j = 0; j < indent * space; j++) {
                    text.insert(i + 2 + j, " ");
                }
                i += 1 + indent * space;
                break;

            case '{':
                indent++;
                text.insert(i + 1, "\n");
                for (int j = 0; j < indent * space; j++) {
                    text.insert(i + 2 + j, " ");
                }
                i += 1 + indent * space;
                break;

            case '}':
                if (indent != 0) {
                    indent--;
                }
                text.insert(i, "\n");
                for (int j = 0; j < indent * space; j++) {
                    text.insert(i + 1, " ");
                }

                i += 2 + indent * space;
                text.insert(i, "\n");
                for (int j = 0; j < indent * space; j++) {
                    text.insert(i + 1 + j, " ");
                }
                i += 1 + indent * space;
                break;

            default:
                break;
        }
    }
    Main.write("src/main/resources/output", text);
    System.out.print(text);

}
    /**
     * default constructor.
     */
    private Main() {

    }

    /**
     * read from a file.
     * @param fileName file name
     * @return StringBuilder
     */
    private static StringBuilder read(final String fileName)  {
        Logger log = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = new FileInputStream(new File(fileName));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = reader.readLine();
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return sb;
    }

    /**
     * write to file.
     * @param fileName file name
     * @param text text
     */
    private static void write(final String fileName, final StringBuilder text) {
        Logger log = Logger.getAnonymousLogger();
        try {
            OutputStream outputStream = new FileOutputStream(new File(fileName));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            try {
                writer.write(text.toString());
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
