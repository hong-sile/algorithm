/*
판단 조건
- 길이가 같아야 한다.
- 맨 앞, 뒤 문자를 포함해야 한다. -> 아 이거 잘못 이해헀네 맨앞 맨 뒤 문자를 포함해야한다고... 개쉽네
- 정확하게 한 문자만 달라야 한다. -> 이래야했는데 2번째가 다른걸로 짜버렸네

아래 기록 무시... 잘못 문제 이해함
오잉? 그러면 3자리 문자열로만 다 쪼개서 한번 찾아보는건 어떨까?
subString을 구성한 다음에 가운데만 똑 떼기?

이러면 확 준다. 3자리만 찾으면 됨
그러면 subString 수는 N - 2개

근데 그냥 (N-2)^2 때려도 되지 않나? 2000 x 2000이면 시간 제한 1초일 땍 가능

N이 2,000이다.
그렇다고 했을 떄, 어떤 식으로 관리 할 수 있는가?
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BOJ_27962 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static String input;

  public static void main(String[] args) throws Exception {
    input();

    for (int len = 1; len <= N; len++) {
      String prefix = input.substring(0, len);
      String suffix = input.substring(N - len, N);

      // 두 문자열이 정확히 한 문자만 다른지 확인
      if (isOneCharDifferent(prefix, suffix)) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }

  static boolean isOneCharDifferent(String s1, String s2) {
    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffCount++;
        if (diffCount > 1) {
          return false;
        }
      }
    }

    return diffCount == 1;
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = br.readLine();
  }
}
