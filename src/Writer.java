import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Writer {

    OutputStream outputStream;

    Writer (String path) throws FileNotFoundException {
        outputStream = new FileOutputStream(path, false);
    };

    void write (long time) {
        PrintStream printStream = new PrintStream(outputStream, false, StandardCharsets.UTF_8);
        printStream.println(time);
    }
}
