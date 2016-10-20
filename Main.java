import java.io.*;
import  java.util.logging.*;

public class Main {

    public static void main(String [] args){

        StringBuilder text = new StringBuilder();

        text = Main.read("src/input");

        int indent = 0;
        for(int i = 0; i < text.length(); i++){
            switch (text.charAt(i)) {
                case ';':
                    text.insert(i+1,"\n");
                    for(int j = 0; j < indent*4; j++){
                        text.insert(i+2+j," ");
                    }
                    i += 1+indent*4;
                    break;

                case '{':
                    indent++;
                    text.insert(i+1,"\n");
                    for(int j = 0; j < indent*4; j++){
                        text.insert(i+2+j," ");
                    }
                    i += 1+indent*4;
                    break;

                case '}':
                    if(indent !=0)
                        indent--;
                    text.insert(i,"\n");
                    for(int j = 0; j < indent*4; j++){
                        text.insert(i+1," ");
                    }

                    i += 2+indent*4;
                    text.insert(i,"\n");
                    for(int j = 0; j < indent*4; j++){
                        text.insert(i+1+j," ");
                    }
                    i += 1+indent*4;
                    break;
            }
        }
        Main.write("src/output", text);
        System.out.print(text);
    }

    public static StringBuilder read(String fileName)  {
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

    public static void write(String fileName, StringBuilder text) {
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
