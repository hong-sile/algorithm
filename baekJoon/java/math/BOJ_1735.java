package math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1735 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int aDividor;
  private static int aDivide;
  private static int bDividor;
  private static int bDivide;

  private static int maxGcd(int a, int b) {
    return gcd(Math.max(a, b), Math.min(a, b));
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) throws Exception {
    input();
    int gcdDividor = maxGcd(aDividor, bDividor);

    //분모
    int lcmDividor = aDividor * bDividor / gcdDividor;
    //분자
    int sumDivide = (lcmDividor / aDividor) * aDivide + (lcmDividor / bDividor) * bDivide;

    int gcdResult = maxGcd(lcmDividor, sumDivide);
    StringBuilder sb = new StringBuilder();

    sb.append(sumDivide / gcdResult);
    sb.append(" ");
    sb.append(lcmDividor / gcdResult);

    System.out.println(sb.toString());
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    aDivide = Integer.parseInt(st.nextToken());
    aDividor = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    bDivide = Integer.parseInt(st.nextToken());
    bDividor = Integer.parseInt(st.nextToken());
  }
}
