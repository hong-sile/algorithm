package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BOJ_6588 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static final boolean[] checked = new boolean[1000001];
  private static final Queue<Integer> queue = new LinkedList<>();
  private static final Set<Integer> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    settingPrimeNumber();

    int input = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (input != 0) {
      for (int primeNumber : queue) {
        if (set.contains(input - primeNumber)) {
          sb.append(String.format("%d = %d + %d\n", input, primeNumber, input - primeNumber));
          break;
        }
      }
      input = Integer.parseInt(br.readLine());
    }

    System.out.print(sb.toString());
  }

  private static void settingPrimeNumber() {
    checked[0] = true;
    checked[1] = true;
    for (int i = 2; i * i <= 1000000; i++) {
      if (checked[i]) {
        continue;
      }
      for (int j = i * i; j <= 1000000; j += i) {
        checked[j] = true;
      }
    }

    for (int i = 2; i <= 1000000; i++) {
      if (!checked[i]) {
        queue.add(i);
        set.add(i);
      }
    }
  }
}
