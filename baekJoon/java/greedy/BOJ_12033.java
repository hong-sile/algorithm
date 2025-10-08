package greedy;/*
- 각 품목의 판매 가격은 정상 가격의 정확히 75%
- 프린터는 모든 물품의 할인가격과 정상가격을 따로 구분하지 않고 오름차순으로 정렬한 뒤 순서대로 출력하여 하나의 출력물 더미를
- 어느 가격표가 할인가격표인지 확신할 수 없습니다. 이 상황에서 김인천씨는 무엇이 할인가격표인지 구분해낼 수 있을까요?


시간제한 5초
- T <= 100
- P_i <= 10^9
- N <= 4

BF로 할 수 있을 듯? 5초고 4이 4, T가 100이면 그리 많지 않음. Set으로 값 다 넣고 erase한느게 젤 빠를 듯함.
Set으로 할 대 값이 여러개인 걸 생각해야함.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12033 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static Map<Long, Integer> sets;
  private static Long[] values;
  private static int N;

  public static void main(String[] args) throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int time = 1;

    while (time <= T) {
      readCommands(br);

      StringBuilder sb = new StringBuilder();
      sb.append("Case #").append(time).append(": ");

      for (int i = 0; i < 2 * N; i++) {
        long expectedSalePrice = values[i];
        long expectedOriginPrice = expectedSalePrice / 3L * 4L;

        if (!sets.containsKey(expectedOriginPrice)) {
          continue;
        }
        if (!sets.containsKey(expectedSalePrice)) {
          continue;
        }

        sb.append(expectedSalePrice).append(" ");

        int count = sets.get(expectedOriginPrice);
        if (count - 1 == 0) {
          sets.remove(expectedOriginPrice);
        } else {
          sets.put(expectedOriginPrice, count - 1);
        }

        count = sets.get(expectedSalePrice);
        if (count - 1 == 0) {
          sets.remove(expectedSalePrice);
        } else {
          sets.put(expectedSalePrice, count - 1);
        }
      }
      System.out.println(sb.toString());
      time++;
    }
  }

  private static void readCommands(final BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    sets = new HashMap<>();
    values = new Long[N * 2];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int index = 0; index < N * 2; index++) {
      final long price = Long.parseLong(st.nextToken());
      values[index] = price;
      sets.merge(price, 1, Integer::sum);
    }
  }
}
