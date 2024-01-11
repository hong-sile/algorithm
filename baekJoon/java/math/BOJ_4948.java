package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_4948 {

    private static final int N = 123456;
    private static final int SIZE = 2 * N;
    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
    private static final BufferedReader BR;
    private static final boolean[] NON_PRIME_NUMBERS_CHECK = new boolean[SIZE + 1];

    static {
        BR = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        initPrimeNumber();
        for (int number = input(); number != 0; number = input()) {
            int ans = solution(number);
            System.out.println(ans);
        }
    }

    private static int solution(final int number) {
        int ans = 0;
        for (int i = number + 1; i <= number * 2; i++) {
            if (!NON_PRIME_NUMBERS_CHECK[i]) {
                ans++;
            }
        }
        return ans;
    }

    private static void initPrimeNumber() {
        NON_PRIME_NUMBERS_CHECK[0] = true;
        NON_PRIME_NUMBERS_CHECK[1] = true;
        for (int i = 2; i <= SIZE; i++) {
            if (NON_PRIME_NUMBERS_CHECK[i]) {
                continue;
            }
            for (int j = 2 * i; j <= SIZE; j = j + i) {
                NON_PRIME_NUMBERS_CHECK[j] = true;
            }
        }
    }

    public static Integer input() throws IOException {
        final StringTokenizer st = new StringTokenizer(BR.readLine());
        return Integer.valueOf(st.nextToken());
    }

    private static void setIO() throws FileNotFoundException {
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
    }
}
