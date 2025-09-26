package dp;

/*
i가 value고, 실제 value가 weight로 하면 될까?

즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다. -> 요게 좀 중요해보이네
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_16194 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] DECK;
  private static int[] DP;

  public static void main(String[] args) throws IOException {
    input();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        DP[i] = Math.min(DP[i], DP[i - j] + DECK[j]);
      }
    }
    System.out.print(DP[N]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    DECK = new int[N + 1];
    DP = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int index = 1; index <= N; index++) {
      DECK[index] = Integer.parseInt(st.nextToken());
      DP[index] = DECK[index];
    }

  }
}
