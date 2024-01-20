package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1629 {

    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

    private static long A;
    private static long B;
    private static long C;

    public static void main(String[] args) throws IOException {
        input();
        final long ans = solution(A, B);
        System.out.println(ans);
    }

    private static long solution(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }

        long half = solution(base, exponent / 2);

        if (exponent % 2 == 1) {
            return (half * half % C) * base % C;
        }
        return half * half % C;
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.valueOf(st.nextToken());
        B = Long.valueOf(st.nextToken());
        C = Long.valueOf(st.nextToken());
    }
}
