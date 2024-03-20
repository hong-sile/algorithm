package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1937 {

  private static final int UNCHECKED = -1;
  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
  private static final int[] dy = {1, 0, -1, 0};
  private static final int[] dx = {0, 1, 0, -1};

  private static int N;
  private static int[][] MAP;
  private static int[][] MOVE_COUNT;

  public static void main(String[] args) throws IOException {
    input();
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        max = Integer.max(dfs(i, j), max);
      }
    }
    System.out.println(max);
  }

  private static int dfs(int y, int x) {
    if (MOVE_COUNT[y][x] != UNCHECKED) {
      return MOVE_COUNT[y][x];
    }

    MOVE_COUNT[y][x] = 1;
    int max = 0;

    for (int i = 0; i < 4; i++) {
      int nextY = y + dy[i];
      int nextX = x + dx[i];
      if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N ||
          MAP[nextY][nextX] <= MAP[y][x]) {
        continue;
      }
      max = Integer.max(max, dfs(nextY, nextX));
    }
    MOVE_COUNT[y][x] += max;

    return MOVE_COUNT[y][x];
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    MAP = new int[N][N];
    MOVE_COUNT = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        MAP[i][j] = Integer.parseInt(st.nextToken());
        MOVE_COUNT[i][j] = UNCHECKED;
      }
    }
  }
}
