package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14002 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  static class Node {

    int index;
    int value;

    public Node(final int index, final int value) {
      this.index = index;
      this.value = value;
    }
  }

  private static int N;
  private static int[] arr;
  private static Node[] lis;
  private static int[] invertedIndex;

  public static void main(String[] args) throws Exception {
    input();

    int length = 0;
    lis[0] = new Node(0, 0);
    for (int i = 1; i <= N; i++) {
      if (lis[length].value < arr[i]) {
        length += 1;
        lis[length] = new Node(i, arr[i]);
        invertedIndex[i] = lis[length-1].index;
        continue;
      }

      int index = binarySearch(lis, length, arr[i]);
      if (index < 0) {
        index = -index - 1;
      }
      lis[index] = new Node(i, arr[i]);
      invertedIndex[i] = lis[index-1].index;
    }

    System.out.println(length);
    StringBuilder sb = new StringBuilder();
    int index = lis[length].index;
    while (index != 0) {
      sb.insert(0, " ");
      sb.insert(0, arr[index]);
      index = invertedIndex[index];
    }
    System.out.println(sb.toString());
  }

  private static int binarySearch(Node[] arr, int length, int target) {
    int start = 0;
    int end = length;

    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid].value < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return end;
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
    lis = new Node[N + 1];
    invertedIndex = new int[N + 1];

    for (int index = 1; index <= N; index++) {
      arr[index] = Integer.parseInt(st.nextToken());
    }
  }

}
