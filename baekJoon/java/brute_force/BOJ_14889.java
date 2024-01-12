package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

/**
 * N이 4에서 20이고, 시간 제한은 2초 brute force로 가능할 듯?
 * <p>
 * 고려해야할 것
 * <p>
 * 1. N개중 N/2 개를 선택하는 방법
 * <p>
 * 2. 중복이 있어서 반으로 줄여야함 -> 이거 안해도 통과할 것 같긴 함 -> 해야 통과함
 */

public class BOJ_14889 {

    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] score;
    static boolean[] checkPickNumber;

    public static void main(String[] args) throws Exception {
        input();
        solutionDp(0, -1);
        System.out.println(ans);
    }

    private static void solutionDp(int pickNumber, int lastIndex) {
        if (pickNumber == N / 2) {
            ans = Math.min(calculateDiff(), ans);
            return;
        }
        for (int i = lastIndex + 1; i < N; i++) {
            if (checkPickNumber[i]) {
                continue;
            }
            checkPickNumber[i] = true;
            solutionDp(pickNumber + 1, i);
            checkPickNumber[i] = false;
        }
    }

    private static int calculateDiff() {
        int checkedScore = 0;
        int uncheckedScore = 0;

        for (int i = 0; i < N; i++) {
            if (checkPickNumber[i]) {
                for (int j = 0; j < N; j++) {
                    if (!checkPickNumber[j] || i == j) {
                        continue;
                    }
                    checkedScore += score[i][j];
                }
            } else {
                for (int j = 0; j < N; j++) {
                    if (checkPickNumber[j] || i == j) {
                        continue;
                    }
                    uncheckedScore += score[i][j];
                }
            }
        }
        return Math.abs(checkedScore - uncheckedScore);
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());

        score = new int[N][N];
        checkPickNumber = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
