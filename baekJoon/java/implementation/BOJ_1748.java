package implementation;/*
수학 식으로 도출 가능할 것 같음.
N이 몇자리수인지 확인하고, 그 만큼 계산해서 더하기.

9 x 1
90 x 2
900 x 3
...

 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1748 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  public static void main(String[] args) throws Exception {
    int input = input();
    int n = input;
    int digits = 0;
    while (n != 0) {
      n = n / 10;
      digits++;
    }

    int result = 0;
    int digitsCount = 9;
    for (int i = 1; i < digits; i++) {
      result += digitsCount * i;
      digitsCount *= 10;
    }

    int lastDigitNumbers = (input - (int) Math.pow(10, digits - 1) + 1) * digits;
    result += lastDigitNumbers;

    System.out.println(result);
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
