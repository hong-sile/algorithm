package implementation;/*
문제를 보았을 때 a가 100, b가 1,000,000
단순 계산하는 식으로는 절대 안됨.

포인트는 2가지
마지막 자리 숫자만 중요하다.
수학적으로는 아무리 많아도 10번 내로 다시 자기 숫자로 돌아온다. 수학의 군 개념

그러면 다시 자기 원래 숫자로 돌아오는 count를 파악해서 b로 그 count를 나눈 나머지만큼 만 곱하면 됨.
아무리 많아도 20번
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1009 {

  private static final String INPUT_DIR = "baekjoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekjoon/java/output.txt";

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    final int T = Integer.parseInt(st.nextToken());

    for (int index = 0; index < T; index++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int result = solution(a, b);
      System.out.println(result);
    }
  }

  private static int solution(int a, int b) {
    a = a % 10;
    if (a == 0) {
      return 10;
    }

    int count = 0;
    int current = a;
    do {
      current = current * a;
      current = current % 10;
      count++;
    } while (current != a);

    if (count == 1) {
      return a;
    }

    int remainder = b % count;
    if (remainder == 0) {
      remainder = count;
    }
    int result = 1;
    for (int i = 0; i < remainder; i++) {
      result *= a;
      result %= 10;
    }
    return result == 0 ? 10 : result;
  }
}
