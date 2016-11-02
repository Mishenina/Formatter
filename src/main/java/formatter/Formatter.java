package formatter;


/**
 * Formatter from in to out.
 */
public class Formatter implements IFormatter {
    /**
     * text formatting.
     * @param in input text
     * @param out output text
     */
    public final void format(final IReader in, final IWriter out) {

        StringBuilder inputText = in.read("src/main/resources/input");

        final int space = 4;
        int indent = 0;
        for (int i = 0; i < inputText.length(); i++) {
            switch (inputText.charAt(i)) {
                case ';':
                    inputText.insert(i + 1, "\n");
                    for (int j = 0; j < indent * space; j++) {
                        inputText.insert(i + 2 + j, " ");
                    }
                    i += 1 + indent * space;
                    break;

                case '{':
                    indent++;
                    inputText.insert(i + 1, "\n");
                    for (int j = 0; j < indent * space; j++) {
                        inputText.insert(i + 2 + j, " ");
                    }
                    i += 1 + indent * space;
                    break;

                case '}':
                    if (indent != 0) {
                        indent--;
                    }
                    inputText.insert(i, "\n");
                    for (int j = 0; j < indent * space; j++) {
                        inputText.insert(i + 1, " ");
                    }

                    i += 2 + indent * space;
                    inputText.insert(i, "\n");
                    for (int j = 0; j < indent * space; j++) {
                        inputText.insert(i + 1 + j, " ");
                    }
                    i += 1 + indent * space;
                    break;

                default:
                    break;
            }
        }
        out.write("src/main/resources/output", inputText);
        System.out.print(inputText);
    }
}
