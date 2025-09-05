package implementation;

/*
길이가 크지 않다. 모든 문자를 다 검색해도 50 x 50 정도이다.
그러면 그냥 모든 문자열의 index를 하나씩 돌면서 다르면 ? 모두 같다면 그 값을 쓰자.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1032 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static String[] FILES = new String[50];

  public static void main(String[] args) throws Exception {
    input();
    int fileLength = FILES[0].length();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < fileLength; i++) {
      char previousChar = FILES[0].charAt(i);
      boolean same = true;
      for (int j = 1; j < N; j++) {
        char current = FILES[j].charAt(i);
        if (current != previousChar) {
          same = false;
          break;
        }
      }

      if (same) {
        sb.append(previousChar);
      } else {
        sb.append("?");
      }
    }

    System.out.println(sb.toString());
  }

  private static void input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    for (int index = 0; index < N; index++) {
      st = new StringTokenizer(br.readLine());
      FILES[index] = st.nextToken();
    }
  }
}
