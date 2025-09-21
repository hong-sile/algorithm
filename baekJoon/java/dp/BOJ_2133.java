package dp;/*
N이 30 생각보다 작다? 이거 그냥 수식 잘 찾아서 bf 때려도 되는 숫자임
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_2133 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] DP = new int[31];

  public static void main(String[] args) throws Exception {
    input();

    DP[0] = 1;
    DP[1] = 0;
    DP[2] = 3;

    for (int i = 4; i <= N; i = i + 2) {
      DP[i] = DP[i - 2] * 3;
      for (int j = i - 4; j >= 0; j = j - 2) {
        DP[i] += (DP[j] * 2);
      }
    }

    System.out.println(DP[N]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
  }
}
