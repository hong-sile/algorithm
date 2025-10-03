/*
당연히 BF는 안됨

구해야하는 건 없얘야하는 전깃줄의 개수
같은 위치에 2개의 전깃줄이 인결될 수 없음

어떤 전깃줄을 없얘야하는 지도 알 수 있을까?

어떻게 하면 이번 전깃줄이 기존 전깃줄에 영향을 끼친다는 걸 알 수 있을까?
- 기존 도착지들을 별도로 변수에 저장해둔 다음에 현재 탐색하는 곳이 기존임.

아 보니까 연속해서 증가하는 수열을 찾으면 됨.
 */
package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] LINK = new int[501];
  private static int[] LIS = new int[501];

  private static int MAX_FLOOR = 0;
  private static int LIS_LENGTH = 0;

  public static void main(String[] args) throws Exception {
    input();

    for (int i = 1; i <= MAX_FLOOR; i++) {
      if (LINK[i] == 0) {
        continue;
      }
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

    for (int index = 1; index <= N; index++) {
      st = new StringTokenizer(br.readLine());
      int floor = Integer.parseInt(st.nextToken());

      LINK[floor] = Integer.parseInt(st.nextToken());
      MAX_FLOOR = Math.max(MAX_FLOOR, floor);
    }
  }
}
