import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Generator {
    Generator () {}

    public void completion () throws Exception {
        for (int i = 100; i <= 10000; i+= 100) {
            String path = "data/Test" + i + ".txt";
            new File(path);
            OutputStream outputStream = new FileOutputStream(path, false);
            PrintStream printStream = new PrintStream(outputStream, false, StandardCharsets.UTF_8);
            printStream.println(i);
            int l = (int) (Math.random() * (i - 99));
            int r = l + 99;
            printStream.println(l);
            printStream.println(r);
            printStream.println((int) (Math.random() * i));
            printStream.println( (int) (Math.random() * (2000000000 + 1) - 1000000000) );
            for (int j = 0; j < i; j++) {
                printStream.println( (int) (Math.random() * (2000000000 + 1) - 1000000000) );
            }
        }
    }

}
