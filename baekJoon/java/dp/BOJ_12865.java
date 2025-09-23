package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_12865 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static final int WEIGHT_INDEX = 0;
  private static final int VALUE_INDEX = 1;

  private static int N;
  private static int K;
  private static int[][] goods;
  private static int[][] DP;

  public static void main(String[] args) throws Exception{
    input();

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= K; j++) {
        int weight = goods[i][WEIGHT_INDEX];
        int value = goods[i][VALUE_INDEX];
        if (j >= weight) {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - weight] + value);
        } else {
          DP[i][j] = DP[i - 1][j];
        }
      }
    }
    System.out.println(DP[N][K]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    DP = new int[N+1][K+1];
    goods = new int[N+1][2];

    for (int index = 1; index <= N; index++) {
      st = new StringTokenizer(br.readLine());
      goods[index][WEIGHT_INDEX] = Integer.parseInt(st.nextToken());
      goods[index][VALUE_INDEX] = Integer.parseInt(st.nextToken());
    }
  }
}
