package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_11057 {

    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
    private static final int MOD = 10007;

    private static int N;
    private static int[][] DP;

    public static void main(String[] args) throws IOException {
        input();
        initDP();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    DP[i][j] += DP[i - 1][k];
                    DP[i][j] %= MOD;
                }
            }
        }

        System.out.println(DP[N][0] % MOD);
    }

    private static void initDP() {
        DP = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            DP[0][i] = 1;
        }
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }
}
