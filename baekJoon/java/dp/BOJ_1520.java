package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1520 {

  private static final int UNCHECKED = -1;
  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
  private static final int[] dy = {1, 0, -1, 0};
  private static final int[] dx = {0, 1, 0, -1};

  private static int N;
  private static int M;
  private static int[][] MAP;
  private static int[][] SOLUTION;

  public static void main(String[] args) throws IOException {
    input();

    int ans = solution(0, 0);
    System.out.println(ans);
  }

  private static int solution(int n, int m) {
    if (n == N - 1 && m == M - 1) {
      return 1;
    }
    if (SOLUTION[n][m] != UNCHECKED) {
      return SOLUTION[n][m];
    }
    SOLUTION[n][m] = 0;
    for (int i = 0; i < 4; i++) {
      final int nextY = n + dy[i];
      final int nextX = m + dx[i];
      if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M
          || MAP[n][m] <= MAP[nextY][nextX]) {
        continue;
      }
      SOLUTION[n][m] += solution(nextY,nextX);
    }
    return SOLUTION[n][m];
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    MAP = new int[N][];
    SOLUTION = new int[N][];

    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      MAP[y] = new int[M];
      SOLUTION[y] = new int[M];

      for (int x = 0; x < M; x++) {
        MAP[y][x] = Integer.parseInt(st.nextToken());
        SOLUTION[y][x] = UNCHECKED;
      }
    }
  }
}
