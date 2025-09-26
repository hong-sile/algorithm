package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BOJ_2193 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static long[][] DP = new long[91][2];
  private static int N;

  public static void main(String[] args) throws IOException {
    input();
    DP[1][0] = 0;
    DP[1][1] = 1;

    for (int i = 2; i <= 90; i++) {
      DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
      DP[i][1] = DP[i - 1][0];
    }

    System.out.println(DP[N][0] + DP[N][1]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
  }
}
