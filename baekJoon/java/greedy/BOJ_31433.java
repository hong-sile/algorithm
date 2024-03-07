package greedy;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_31433 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static Map<Character, Character> nextCharMap = Map.of(
      'K', 'S', 'S', 'A', 'A', 'K'
  );
  private static String input;

  public static void main(final String[] args) throws IOException {
    input();
    final int solveStartWithK = solveStartWith('K');
    final int solveStartWithS = solveStartWith('S');
    final int solveStartWithA = solveStartWith('A');

    int min = min(solveStartWithK, solveStartWithS);
    min = min(min, solveStartWithA);

    System.out.println(min);
  }

  public static int solveStartWith(final char startChar) {
    final String s = String.valueOf(input);
    final int inputLength = input.length();

    final int startIndex = s.indexOf(startChar);
    if (startIndex == -1) {
      return Integer.MAX_VALUE;
    }
    int cnt = startIndex;

    char prevChar = startChar;
    for (int index = startIndex + 1; index < inputLength; index++) {
      if (nextCharMap.get(prevChar) == input.charAt(index)) {
        prevChar = input.charAt(index);
        continue;
      }
      cnt += 1;
    }

    if (startChar == 'S' && cnt < 1) {
      cnt = 1;
    } else if (startChar == 'A' && cnt < 2) {
      cnt = input.length() - startIndex;
    }
    return cnt * 2;
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    input = st.nextToken();
  }
}
