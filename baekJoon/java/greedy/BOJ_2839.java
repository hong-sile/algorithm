package greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_2839 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  public static void main(String[] args) throws Exception {
    int total = input();

    for (int i = 0; i < 5; i++) {
      int remain = total - (3 * i);
      if (remain >= 0) {
        if (remain % 5 ==0) {
          final int fiveBag = remain / 5;
          System.out.println(fiveBag + i);
          return;
        }
      }
    }
    System.out.println(-1);
  }

  private static int input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }
}
