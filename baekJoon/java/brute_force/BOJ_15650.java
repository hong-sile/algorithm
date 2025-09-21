package brute_force;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

/*
이것 또한 수가 8 백트래킹을 한다고 해도 8C4.
백트래킹 하고 사전 순 정렬 잊지 말기.
순서에 상관없이 들어간게, 이미 있다고 어떻게 판단하지?
 */

public class BOJ_15650 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static final boolean[] checked = new boolean[9];
  private static int N;
  private static int M;

  public static void backTracking(int depth, int start) {
    if (depth == M) {
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= N; i++) {
        if(checked[i]){
          sb.append(i).append(" ");
        }
      }
      System.out.println(sb.toString());
      return;
    }

    for (int i = start; i <= N; i++) {
      if (checked[i]) {
        continue;
      }
      checked[i] = true;
      backTracking(depth + 1, i);
      checked[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    input();
    backTracking(0, 1);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
  }
}
