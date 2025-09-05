package implementation;/*
구간을 볼 때 마다 새 배열만들고 그 배열에 값을 for문 역순으로 복사한 다음 집어넣기
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class BOJ_10804 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static final int[][] COMMANDS = new int[10][2];
  private static final int[] DECK
      = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

  public static void main(String[] args) throws Exception {
    input();
    for (int i = 0; i < 10; i++) {
      int startIndex = COMMANDS[i][0];
      int endIndex = COMMANDS[i][1];

      int[] targetRange = Arrays.copyOfRange(DECK, startIndex, endIndex + 1);
      for (int j = startIndex; j <= endIndex; j++) {
        DECK[j] = targetRange[endIndex - j];
      }
    }

    for (int i = 1; i <= 20; i++) {
      System.out.print(DECK[i] + " ");
    }
  }

  private static void input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    for (int index = 0; index < 10; index++) {
      st = new StringTokenizer(br.readLine());
      COMMANDS[index][0] = Integer.parseInt(st.nextToken());
      COMMANDS[index][1] = Integer.parseInt(st.nextToken());
    }
  }
}
