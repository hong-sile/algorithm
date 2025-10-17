package dp;/*
그냥 3중 for문 때려도 될듯?
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BOJ_1958 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static String first;
  private static String second;
  private static String third;
  private static int[][][] DP;

  public static void main(String[] args) throws IOException {
    input();

    for (int i = 1; i <= first.length(); i++) {
      char firstChar = first.charAt(i - 1);
      for (int j = 1; j <= second.length(); j++) {
        char secondChar = second.charAt(j - 1);
        for (int k = 1; k <= third.length(); k++) {
          char thirdChar = third.charAt(k - 1);

          if (firstChar == secondChar && secondChar == thirdChar) {
            DP[i][j][k] = DP[i - 1][j - 1][k - 1] + 1;
          } else {
            DP[i][j][k] = Math.max(Math.max(DP[i - 1][j][k], DP[i][j - 1][k]), DP[i][j][k - 1]);
          }
        }
      }
    }
    System.out.println(DP[first.length()][second.length()][third.length()]);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    first = br.readLine();
    second = br.readLine();
    third = br.readLine();

    DP = new int[first.length() + 1][second.length() + 1][third.length() + 1];
  }
}
