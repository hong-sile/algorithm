package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BOJ_1965 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int[] box;
  private static int[] insertedBox;

  public static void main(String[] args) throws Exception {
    input();
    int insertedBoxLength = 0;

    for (int i = 1; i <= N; i++) {
      if (box[i] > insertedBox[insertedBoxLength]) {
        insertedBoxLength += 1;
        insertedBox[insertedBoxLength] = box[i];
        continue;
      }
      int targetIndex = binearySearch(insertedBox, insertedBoxLength, box[i]);
      insertedBox[targetIndex] = box[i];
    }
    System.out.println(insertedBoxLength);
  }

  private static int binearySearch(int[] arr, int length, int target) {
    int max = length;
    int min = 0;

    while (min < max) {
      int mid = (min + max) / 2;
      if (arr[mid] < target) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }

    return min;
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    box = new int[N + 1];
    insertedBox = new int[N + 1];
    st = new StringTokenizer(br.readLine());

    for (int index = 1; index <= N; index++) {
      box[index] = Integer.parseInt(st.nextToken());
    }
  }
}
