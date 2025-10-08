package greedy;/*
입력
첫째 줄에는 나무의 개수  $n$개가 있다. 나무는 $1$번부터 $n$번까지 있다.

다음 줄에는 첫날 올라갔을 때 나무의 길이들  $H_i$가  $n$개가 순서대로 주어진다.

그 다음 줄에는 나무들이 자라는 길이 $A_i$가 $n$개가 순서대로 주어진다.

자른 이후에도 나무는 0부터 다시 자라기 때문에 -> 아 이게 좀 크네.

이러면 그리디하게 가져가도 되지 않나? -> 고민을 해보자.

5
1 3 2 4 6
2 7 3 4 1

1. 1 3 2 4 0
2. 3 0 5 8 1
3. 5 7 7 0 2
4. 7 0 9 4 3
5. 9 7 0 8 4


6 + 10 + 8 + 14 + 11

1. 그리디하게 가능한가?
- 자르는 나무는 한 번만 자르도록 하는게 좋고, 증가량 순서로 정렬해서 자르는게 좋음
- 근데 이게 늘 정해인가? 는 고민해봐야함.
- n개의 나무고 n일동안이라서 빠지는 나무가 없음 이게 정해임.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14727 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static Long[] increases;
  private static Long result = 0L;

  public static void main(String[] args) throws IOException {
    input();

    Arrays.sort(increases);
    for (int i = 0; i < N; i++) {
      result += increases[i] * i;
    }

    System.out.println(result);
  }

  private static void input() throws IOException {
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    increases = new Long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      result += Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      increases[i] = Long.parseLong(st.nextToken());
    }
  }
}
