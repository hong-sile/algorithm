package implementation;/*
전반적으로 그냥 구현만 하면 되는 문제, 입력 받는 거만 좀 귀찮을 듯 하다.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class BOJ_2167 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static final int[][] MAP = new int[301][301];
  private static int N;
  private static int M;
  private static int K;
  private static final int[][] COMMANDS = new int[10000][4];

  public static void main(String[] args) throws Exception {
    input();
    for (int i = 0; i < K; i++) {
      int yA = COMMANDS[i][0];
      int xA = COMMANDS[i][1];
      int yB = COMMANDS[i][2];
      int xB = COMMANDS[i][3];

      int result = 0;
      for (int j = yA; j <= yB; j++) {
        for (int k = xA; k <= xB; k++) {
          result += MAP[j][k];
        }
      }
      System.out.println(result);
    }
  }

  private static void input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        MAP[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      COMMANDS[i][0] = Integer.parseInt(st.nextToken());
      COMMANDS[i][1] = Integer.parseInt(st.nextToken());
      COMMANDS[i][2] = Integer.parseInt(st.nextToken());
      COMMANDS[i][3] = Integer.parseInt(st.nextToken());
    }
  }
}
