/*
아 어렵다.

1초고, 개수는 좀 적다, 30개랑 7개? 근데 backtracking으로 하기엔 무리가 있다.
DP 같긴하다.

이 문제는 주어진 추로 구슬과 연산을 만들 수 있는지 느낌
구슬 + 추무게 + ... = 추무게 + ...
이 성립하면 끝,

뭔가 사전계산으로 되는게 없을까? 조금더 단순화를 시킬순없을까?
위의 수식을 단순화 하면
구슬 = 절대값(추 무게 +-)과 하면 상관없다.

만약 구슬이 1개라 가정하면?
  0
1
4
 */
package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BOJ_2629 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int[] WEIGHTS = new int[30];
  private static int N;
  private static int[] BALLS = new int[7];
  private static int B;
  private static boolean[] DP = new boolean[40001];
  private static int MAX = 0;

  public static void main(String[] args) throws Exception {
    input();
    DP[0] = true;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = MAX; j >= 0; j--) {
        if (DP[j]) {
          DP[j + WEIGHTS[i]] = true;
        }
      }
      for (int j = 0; j <= MAX; j++) {
        if (DP[j]) {
          DP[Math.abs(j - WEIGHTS[i])] = true;
        }
      }
    }

    for (int i = 0; i < B; i++) {
      if (DP[BALLS[i]]) {
        sb.append("Y ");
      } else {
        sb.append("N ");
      }
    }

    System.out.println(sb);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    final String[] weights = br.readLine().split(" ");
    for (int index = 0; index < N; index++) {
      WEIGHTS[index] = Integer.parseInt(weights[index]);
      MAX += WEIGHTS[index];
    }

    B = Integer.parseInt(br.readLine());
    final String[] balls = br.readLine().split(" ");
    for (int index = 0; index < B; index++) {
      BALLS[index] = Integer.parseInt(balls[index]);
    }
  }
}
