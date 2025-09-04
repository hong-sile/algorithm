package implementation;/*
보편적인 피보나치 문제
단순하게 n번째 까지 가는 방법이더라도, n이 45이기 때문에 풀이 가능

그렇지만 DP 연습하는 김에 DP로 풀어보기.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2747 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
  private static final int[] DP = new int[46];
  private static final boolean[] VISITED = new boolean[46];

  private static int fibo(int n){
    if(VISITED[n]){
      return DP[n];
    }
    DP[n-1] = fibo(n-1);
    VISITED[n-1] = true;
    DP[n-2] = fibo(n-2);
    VISITED[n-2] = true;
    return DP[n-1] + DP[n-2];
  }

  public static void main(String[] args) throws Exception {
    DP[0] = 0;
    DP[1] = 1;
    VISITED[0] = true;
    VISITED[1] = true;
    int n = input();
    int result = fibo(n);
    assert result == 55;
  }

  private static int input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }
}
