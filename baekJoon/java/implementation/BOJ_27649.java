package implementation;/*
토크나이저는 다음과 같은 방식으로 동작한다.

1. 문자열을 앞에서부터 읽어나간다.
2. 구분자를 만나면 구분자의 앞뒤를 자른다. 이후 구분자의 다음 위치부터 다시 읽어나간다. 이때 잘린 문자열을 토큰이라고 한다.
3. 문자열의 끝에 도달할 경우, 앞에서부터 차례대로 토큰들을 공백으로 구분하여 출력한다. 단, 토큰이 공백일 경우 출력하지 않는다.


 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BOJ_27649 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static String input;
  private static Set<String> delimiters = Set.of(
      "<", ">", "&&", "||", "(", ")", " "
  );

  public static void main(String[] args) throws Exception {
    input();
    List<String> tokens = new LinkedList<>();

    int startIndex = 0;
    int endIndex = 0;
    int length = input.length();

    while (endIndex < length) {
      String delimiterCandidate = input.substring(endIndex, endIndex + 1);
      //한글자 인 경우
      if (delimiters.contains(delimiterCandidate)) {
        final String token = input.substring(startIndex, endIndex);
        tokens.add(token);
        tokens.add(delimiterCandidate);
        endIndex = endIndex + 1;
        startIndex = endIndex;
        continue;
      }
      //두 글자인 경우
      if (endIndex + 1 < length) {
        delimiterCandidate = input.substring(endIndex, endIndex + 2);

        if (delimiters.contains(delimiterCandidate)) {
          final String token = input.substring(startIndex, endIndex);
          tokens.add(token);
          tokens.add(delimiterCandidate);
          endIndex = endIndex + 2;
          startIndex = endIndex;
          continue;
        }
      }
      endIndex++;
    }
    tokens.add(input.substring(startIndex, endIndex));

    StringBuilder sb = new StringBuilder();
    for (final String token : tokens) {
      if (token.trim().equals("")) {
        continue;
      }
      sb.append(token).append(" ");
    }
    System.out.println(sb.toString());
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input = br.readLine();
  }
}
