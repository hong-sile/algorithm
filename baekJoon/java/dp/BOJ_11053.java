/*
arr -> 실제 입력된 배열
insertedArr -> 현재 들어간 LIS들

아하, 여기서 LIS는 그대로 두고, Index만 업데이트 하는건가?

    LIS        length
10  [10]       1
20  [10,20]    2
10  [10,20]    1
30  [10,20,30] 3
20  [10,20,30] 3
50  [10,20,30,40] 4

    LIS        length
10  [10]       1
20  [10,20]    2
9   [9,20]    1
30  [9,20,30] 3
20  [9,20,30] 3
50  [9,20,30,40] 4

아 미쳤다. 여기서 실제 InsertedArr의 각 Index들은 각자 따로 의미를 지님 약간 2차원 느낌으로
 */

package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_11053 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] arr;
  private static int[] insertedArr;

  public static void main(String[] args) throws Exception {
    input();

    insertedArr = new int[N + 1];
    int length = 0;
    for (int i = 1; i <= N; i++) {
      //여기를 좀 생각해보자...
      if (insertedArr[length] < arr[i]) {
        length += 1;
        insertedArr[length] = arr[i];
        continue;
      }

      final int index = lowerBound(insertedArr, arr[i], length);
      insertedArr[index] = arr[i];
    }

    System.out.println(length);
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N + 1];
    for (int index = 1; index <= N; index++) {
      arr[index] = Integer.parseInt(st.nextToken());
    }
  }

  //0인 경우는 무시해야함
  private static int lowerBound(int[] arr, int target, int length) {
    int max = length;
    int min = 0;

    while (min < max) {
      int mid = (max + min) / 2;
      if (arr[mid] < target) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }
}
