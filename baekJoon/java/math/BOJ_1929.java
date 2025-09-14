package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1929 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int M;
  private static final boolean[] checked = new boolean[1000001];

  public static void main(String[] args) throws Exception {
    checked[0]= true;
    checked[1]= true;
    input();

    for (int i = 2; i * i <= N; i++) {
      if (checked[i]) {
        continue;
      }
      for (int j = i + 1; j <= N; j++) {
        if (j % i == 0) {
          checked[j] = true;
        }
      }
    }

    for (int i = M; i <= N; i++) {
      if (!checked[i]) {
        System.out.println(i);
      }
    }
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
  }
}
