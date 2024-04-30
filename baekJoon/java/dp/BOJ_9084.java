package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9084 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static BufferedReader br;
  private static int N;
  private static int M;
  private static int T;
  private static List<Integer> coins;
  private static int[][] DP;

  public static void main(String[] args) throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());

    while (T-- > 0) {
      input();
      DP = new int[N][M + 1];
      solution();
      System.out.println(DP[N - 1][M]);
    }
  }

  private static void solution() {
    for (int value = 1; value <= M; value++) {
      final int change = value - coins.get(0);
      if (change < 0 || value % coins.get(0) != 0) {
        DP[0][value] = 0;
      } else {
        DP[0][value] = 1;
      }
    }

    for (int index = 0; index < N; index++) {
      DP[index][0] = 1;
    }

    for (int index = 1; index < N; index++) {
      for (int value = 1; value <= M; value++) {
        for (int count = 0; value - count * coins.get(index) >= 0; count++) {
          DP[index][value] += DP[index - 1][value - count * coins.get(index)];
        }
      }
    }
  }

  private static void input() throws IOException {
    final String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    coins = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      final int coin = Integer.parseInt(st.nextToken());
      coins.add(coin);
    }

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
  }
}
