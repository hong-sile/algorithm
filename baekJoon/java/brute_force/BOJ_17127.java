package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17127 {

    private static final String INPUT_DIR = "baekJoon/java/brute_force/input.txt";
    private static Integer N;
    private static Integer[] trees;
    private static Integer ans = 0;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(ans);
    }

    private static void solution() {
        int leftPoint = 1;
        int rightPoint = 3;

        for (int r = rightPoint; r < N; r++) {
            for (int l = leftPoint; l < r - 1; l++) {
                for (int m = l + 1; m < r; m++) {
                    final Integer calculate = calculate(l, m, r);
                    ans = Integer.max(calculate, ans);
                }
            }
        }
    }

    private static Integer calculate(
        final int leftPoint,
        final int midPoint,
        final int rightPoint
    ) {
        int total = 0;
        int temp = 1;

        for (int i = 0; i < leftPoint; i++) {
            temp = temp * trees[i];
        }
        total += temp;
        temp = 1;

        for (int i = leftPoint; i < midPoint; i++) {
            temp = temp * trees[i];
        }
        total += temp;
        temp = 1;

        for (int i = midPoint; i < rightPoint; i++) {
            temp = temp * trees[i];
        }
        total += temp;
        temp = 1;

        for (int i = rightPoint; i < N; i++) {
            temp = temp * trees[i];
        }
        total += temp;

        return total;
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        trees = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (Integer index = 0; index < N; index++) {
            trees[index] = Integer.valueOf(st.nextToken());
        }
    }
}
