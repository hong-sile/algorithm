package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1535 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[][] human;
  private static int[][] DP;

  public static void main(String[] args) throws Exception {
    input();
    DP = new int[N + 1][101];

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= 100; j++) {
        int lifeLoss = human[i][0];
        int happyGet = human[i][1];

        if (lifeLoss < j) {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - lifeLoss] + happyGet);
        } else {
          DP[i][j] = DP[i - 1][j];
        }
      }
    }

    System.out.println(DP[N][100]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    human = new int[N + 1][2];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int index = 0; index < N; index++) {
      human[index + 1][0] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int index = 0; index < N; index++) {
      human[index + 1][1] = Integer.parseInt(st.nextToken());
    }
  }
}
