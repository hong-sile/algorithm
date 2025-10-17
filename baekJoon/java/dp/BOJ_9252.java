package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BOJ_9252 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static String first;
  private static String second;
  private static int[][] DP;

  public static void main(String[] args) throws Exception {
    input();

    for (int i = 1; i <= first.length(); i++) {

      for (int j = 1; j <= second.length(); j++) {
        char firstChar = first.charAt(i - 1);
        char secondChar = second.charAt(j - 1);

        if (firstChar == secondChar) {
          DP[i][j] = Math.max(DP[i][j], DP[i - 1][j - 1] + 1);
        } else {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
        }
      }
    }

    int y = first.length();
    int x = second.length();
    final StringBuilder sb = new StringBuilder();

    while (y >= 1 && x >= 1) {
      char firstChar = first.charAt(y - 1);
      char secondChar = second.charAt(x - 1);

      if (firstChar == secondChar) {
        sb.insert(0, firstChar);
        y--;
        x--;
      } else {
        int firstDir = DP[y - 1][x];
        int secondDir = DP[y][x - 1];
        if (firstDir > secondDir) {
          y--;
        } else {
          x--;
        }
      }
    }
    System.out.println(DP[first.length()][second.length()]);
    System.out.println(sb.toString());
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    first = br.readLine();
    second = br.readLine();
    DP = new int[first.length() + 1][second.length() + 1];
  }
}
