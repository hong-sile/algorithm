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

public class BOJ_16493 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
  public static final int UNDEFINED = -1;

  private static int N;
  private static int M;

  private static List<Book> books = new ArrayList<>();
  private static int[][] dp;

  public static void main(final String[] args) throws IOException {
    input();
    solution();
    System.out.println(dp[M][N]);
  }

  private static void solution() {
    initDpArray();
    knapsack(N, M);
  }

  private static int knapsack(final int weight, final int index) {
    if (weight == 0 || index == 0) {
      return 0;
    }

    if (dp[index][weight] != -1) {
      return dp[index][weight];
    }

    if (books.get(index - 1).weight > weight) {
      dp[index][weight] = knapsack(weight, index - 1);
      return dp[index][weight];
    }

    dp[index][weight] = Math.max(
        books.get(index - 1).value + knapsack(weight - books.get(index - 1).weight, index - 1)
        , knapsack(weight, index - 1)
    );
    return dp[index][weight];
  }

  private static void initDpArray() {
    dp = new int[M + 1][N + 1];
    for (int i = 0; i < M + 1; i++) {
      for (int j = 0; j < N + 1; j++) {
        dp[i][j] = UNDEFINED;
      }
    }
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int day = Integer.parseInt(st.nextToken());
      int page = Integer.parseInt(st.nextToken());
      books.add(new Book(day, page));
    }
  }

  static class Book {

    public int weight;
    public int value;

    public Book(final int weight, final int value) {
      this.weight = weight;
      this.value = value;
    }
  }
}
