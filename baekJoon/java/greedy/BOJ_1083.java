package greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

/**
 * 영향가는 범위는
 */
public class BOJ_1083 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static Integer[] numbers;
  private static int N;
  private static int canSwapCount;

  public static void main(String[] args) throws Exception {
    input();

    int fixedIndex = 0;
    while (canSwapCount > 0) {
      int canSwapMaxValueIndex = findMax(fixedIndex);
      if (canSwapMaxValueIndex == fixedIndex) {
        fixedIndex++;
        continue;
      }
      for (int i = canSwapMaxValueIndex; i > fixedIndex; i--) {
        final Integer bigger = numbers[i];
        final Integer smaller = numbers[i - 1];
        numbers[i] = smaller;
        numbers[i - 1] = bigger;
      }
      canSwapCount -= (canSwapMaxValueIndex - fixedIndex);
    }

    for (final Integer number : numbers) {
      System.out.print(number + " ");
    }
  }

  private static int findMax(final int startIndex) {
    int max = -1;
    int maxIndex = 0;
    final int maxFindIndex = Math.min(startIndex + canSwapCount, N - 1);
    for (int i = startIndex; i <= maxFindIndex; i++) {
      if (max < numbers[i]) {
        max = numbers[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  private static void input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    numbers = new Integer[N];

    st = new StringTokenizer(br.readLine());
    for (int index = 0; index < N; index++) {
      numbers[index] = (Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine());
    canSwapCount = Integer.parseInt(st.nextToken());
  }
}
