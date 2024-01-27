package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {

    private static final String LEFT_BIG = ">";
    private static final String RIGHT_BIG = "<";
    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

    private static int N;
    private static String[] CHARACTERS;
    private static boolean[] CHECK;
    private static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solution(0, "");

        Collections.sort(answers);

        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
    }

    private static void solution(final int index, final String number) {
        if (index == N + 1) {
            answers.add(number);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (CHECK[i]) {
                continue;
            }
            if (index == 0 || check(number.charAt(index - 1), (char) i + '0', CHARACTERS[index - 1])) {
                CHECK[i] = true;
                solution(index + 1, number + i);
                CHECK[i] = false;
            }
        }
    }

    private static boolean check(final int a, final int b, final String str) {
        if (str.equals(LEFT_BIG)) {
            return a > b;
        } else {
            return a < b;
        }
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());

        CHARACTERS = br.readLine().split(" ");
        CHECK = new boolean[10];
    }
}
