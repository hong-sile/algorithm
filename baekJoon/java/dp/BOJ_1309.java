package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1309 {

    private static final int MODULAR_NUMBER = 9901;
    private static final int BLANK = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

    private static final int[][] CAGE = new int[100001][3];

    private static int N;

    public static void main(String[] args) throws IOException {
        input();
        DP();
        System.out.println((CAGE[N][BLANK] + CAGE[N][LEFT] + CAGE[N][RIGHT]) % MODULAR_NUMBER);
    }

    public static void DP() {
        CAGE[1][BLANK] = 1;
        CAGE[1][LEFT] = 1;
        CAGE[1][RIGHT] = 1;

        for (int i = 2; i <= N; i++) {
            CAGE[i][BLANK] = (CAGE[i - 1][BLANK] + CAGE[i - 1][LEFT] + CAGE[i - 1][RIGHT]) % MODULAR_NUMBER;
            CAGE[i][LEFT] = (CAGE[i - 1][BLANK] + CAGE[i - 1][RIGHT]) % MODULAR_NUMBER;
            CAGE[i][RIGHT] = (CAGE[i - 1][BLANK] + CAGE[i - 1][LEFT]) % MODULAR_NUMBER;
        }
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
    }
}
