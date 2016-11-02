package formatter;

import  java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;


/**
 * Reader to read chars from string.
 */
public class StringReader implements IReader {

    /**
     * read from a file.
     * @param fileName file name
     * @return StringBuilder
     */
    public final StringBuilder read(final String fileName) {
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
     * default constructor.
     */
    public StringReader() {

    }
}
