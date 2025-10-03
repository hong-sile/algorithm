package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] LINK;
  private static int[] LIS;

  private static int MAX_FLOOR = 0;
  private static int LIS_LENGTH = 0;

  public static void main(String[] args) throws Exception {
    input();

    for (int i = 1; i <= N; i++) {
      LIS[i] = 1;

      if (LINK[i] > LIS[LIS_LENGTH]) {
        LIS_LENGTH++;
        LIS[LIS_LENGTH] = LINK[i];
        continue;
      }

      int result = Arrays.binarySearch(LIS, 0, LIS_LENGTH, LINK[i]);
      if (result < 0) {
        result = -result - 1;
      }
      LIS[result] = LINK[i];
    }
    System.out.println(N - LIS_LENGTH);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    LINK = new int[N + 1];
    LIS = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int index = 1; index <= N; index++) {
      LINK[index] = Integer.parseInt(st.nextToken());
    }
  }
}
