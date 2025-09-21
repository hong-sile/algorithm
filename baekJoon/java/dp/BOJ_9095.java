package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_9095 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int[] DP = new int[11];
  private static int N;

  public static void main(String[] args) throws Exception {
    DP[1] = 1;
    DP[2] = 2;
    DP[3] = 4;
    for (int i = 4; i < 11; i++) {
      DP[i] = DP[i - 3] + DP[i - 2]  + DP[i - 1];
    }

    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    while (T > 0) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(DP[n]);
      T--;
    }
  }

  private static void input() throws IOException {
  }
}
