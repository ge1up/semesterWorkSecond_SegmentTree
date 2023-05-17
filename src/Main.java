import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        boolean completion  = true;
        if (completion) {
            new Generator().completion();
        }

        Writer writer1 = new Writer("data/OutputDataSum.txt");
        Writer writer2 = new Writer("data/OutputDataChange.txt");

        for (int k = 100; k <= 10000; k+= 100) {
            String path = "data/Test" + k + ".txt";

            InputStream inputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            int n = Integer.parseInt(reader.readLine());
            int l = Integer.parseInt(reader.readLine());
            int r = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());
            int cVal = Integer.parseInt(reader.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(reader.readLine());
            }

            SegmentTree tree = new SegmentTree(a);

            long timeBegin;
            long timeEnd;

            timeBegin = System.nanoTime();

            tree.sum(tree.v, tree.tl, tree.tr, l, r);

            timeEnd = System.nanoTime();

            writer1.write((timeEnd - timeBegin));

            timeBegin = System.nanoTime();

            tree.update(tree.v, tree.tl, tree.tr, c, cVal);

            timeEnd = System.nanoTime();

            writer2.write((timeEnd - timeBegin));

//        tree.update(tree.v, tree.tl, tree.tr, 2, -7);
//        System.out.println(tree.sum(tree.v, tree.tl, tree.tr, 2, 5));
        }
    }
}