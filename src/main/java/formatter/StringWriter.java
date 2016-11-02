package formatter;

import java.util.logging.Logger;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.IOException;


/**
 * Writer to write to string.
 */
public class StringWriter implements IWriter {

    /**
     * write to file.
     * @param fileName file name
     * @param text text
     */
    public final void write(final String fileName, final StringBuilder text) {
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
    /**
     * default constructor.
     */
    public StringWriter() {

    }
}
