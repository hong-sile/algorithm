package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1991 {

    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;
    private static final String NOT_PRESENT = ".";

    private static Map<String, List<String>> tree = new HashMap<>();
    private static int N;

    static void pre(final String key) {
        if (key.equals(NOT_PRESENT)) {
            return;
        }
        System.out.print(key);
        pre(tree.get(key).get(LEFT_INDEX));
        pre(tree.get(key).get(RIGHT_INDEX));
    }

    static void middle(final String key) {
        if (key.equals(NOT_PRESENT)) {
            return;
        }
        middle(tree.get(key).get(LEFT_INDEX));
        System.out.print(key);
        middle(tree.get(key).get(RIGHT_INDEX));
    }

    static void post(final String key) {
        if (key.equals(NOT_PRESENT)) {
            return;
        }
        post(tree.get(key).get(LEFT_INDEX));
        post(tree.get(key).get(RIGHT_INDEX));
        System.out.print(key);
    }

    public static void main(String[] args) throws IOException {
        input();
        pre("A");
        System.out.println();
        middle("A");
        System.out.println();
        post("A");
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());

        for (int index = 0; index < N; index++) {
            st = new StringTokenizer(br.readLine());
            final String parent = st.nextToken();
            final String child1 = st.nextToken();
            final String child2 = st.nextToken();

            tree.put(parent, List.of(child1, child2));
        }
    }
}
