import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_31475 {

  private static final int blank = 0;
  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static String inputType;
  private static int M;
  private static int N;
  private static int[][] map;

  private static int[] dyClock = {1, 0, -1, 0};
  private static int[] dxClock = {0, -1, 0, 1};
  private static int[] dyClockReverse = {0, 1, 0, -1};
  private static int[] dxClockReverse = {-1, 0, 1, 0};

  public static void main(final String[] args) throws IOException {
    input();
    if (inputType.equals("U")) {
      drawU();
    } else if (inputType.equals("D")) {
      drawD();
    } else if (inputType.equals("L")) {
      drawL();
    } else if (inputType.equals("R")) {
      drawR();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void drawU() {
    final int startX = M / 2;
    final int startY = 0;

    int cnt = 1;
    for (int i = startY; i < N; i++) {
      map[i][startX] = cnt;
      cnt += 1;
    }

    drawClockWise(1, cnt, startX, N - 1);
    drawReverseClockWise(2, cnt, startX, N - 1);
  }

  private static void drawD() {
    final int startX = M / 2;
    final int startY = N - 1;

    int cnt = 1;
    for (int i = startY; i >= 0; i--) {
      map[i][startX] = cnt;
      cnt += 1;
    }

    drawClockWise(3, cnt, startX, 0);
    drawReverseClockWise(0, cnt, startX, 0);
  }

  private static void drawL() {
    final int startX = 0;
    final int startY = N / 2;

    int cnt = 1;
    for (int i = startX; i < M; i++) {
      map[startY][i] = cnt;
      cnt += 1;
    }

    drawClockWise(0, cnt, M - 1, startY);
    drawReverseClockWise(3, cnt, M - 1, startY);
  }

  private static void drawR() {
    final int startX = M - 1;
    final int startY = N / 2;

    int cnt = 1;
    for (int i = startX; i >= 0; i--) {
      map[startY][i] = cnt;
      cnt += 1;
    }

    drawClockWise(2, cnt, 0, startY);
    drawReverseClockWise(1, cnt, 0, startY);
  }

  private static void drawClockWise(
      int dir, int cnt, final int startX, final int startY
  ) {
    int cantMoveCount = 0;
    int nextY = startY;
    int nextX = startX;

    while (cantMoveCount != 3) {
      nextY = nextY + dyClock[dir];
      nextX = nextX + dxClock[dir];
      if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M
          || map[nextY][nextX] != 0) {
        cantMoveCount += 1;
        nextY = nextY - dyClock[dir];
        nextX = nextX - dxClock[dir];
        dir = (dir + 1) % 4;
        continue;
      }
      map[nextY][nextX] = cnt;
      cnt += 1;
      cantMoveCount = 0;
    }
  }

  private static void drawReverseClockWise(
      int dir, int cnt, final int startX, final int startY
  ) {
    int cantMoveCount = 0;
    int nextY = startY;
    int nextX = startX;

    while (cantMoveCount != 3) {
      nextY = nextY + dyClockReverse[dir];
      nextX = nextX + dxClockReverse[dir];
      if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M
          || map[nextY][nextX] != 0) {
        cantMoveCount += 1;
        nextY = nextY - dyClockReverse[dir];
        nextX = nextX - dxClockReverse[dir];
        dir = (dir + 1) % 4;
        continue;
      }
      map[nextY][nextX] = cnt;
      cnt += 1;
      cantMoveCount = 0;
    }
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.valueOf(st.nextToken());
    M = Integer.valueOf(st.nextToken());

    inputType = new StringTokenizer(br.readLine()).nextToken();

    map = new int[N][];
    for (int i = 0; i < N; i++) {
      map[i] = new int[M];
    }
  }
}
