package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_11052 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] DECK = new int[10001];
  private static int[] DP = new int[10001];

  public static void main(String[] args) throws IOException {
    input();

    DP[0] = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        DP[i] = Math.max(DP[i], DP[i - j] + DECK[j]);
      }
    }

    System.out.println(DP[N]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int index = 1; index <= N; index++) {
      DECK[index] = Integer.parseInt(st.nextToken());
    }
  }
}
