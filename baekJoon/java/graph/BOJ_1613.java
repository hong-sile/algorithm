package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


/**
 * 한 정점에서 다른 정점으로 이동 가능 할 때 우선순위 여부를 알 수 있음 거꾸로도 해보고 둘다 없는 경우 0으로 처리
 */
public class BOJ_1613 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static BufferedReader br;
  private static int N;
  private static int K;
  private static boolean[][] graph;

  public static void main(String[] args) throws IOException {
    initGraph();
    initHistory();
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    while (T-- > 0) {
      step();
    }
  }

  private static void step() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    final boolean startFirst = graph[start][end];
    final boolean endFirst = graph[end][start];

    if (startFirst) {
      System.out.println(-1);
    } else if (endFirst) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  private static void initHistory() {
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (graph[i][k] && graph[k][j]) {
            graph[i][j] = true;
          }
        }
      }
    }
  }

  private static void initGraph() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    graph = new boolean[N + 1][N + 1];

    for (int index = 0; index < K; index++) {
      st = new StringTokenizer(br.readLine());
      int prev = Integer.parseInt(st.nextToken());
      int next = Integer.parseInt(st.nextToken());
      graph[prev][next] = true;
    }
  }
}
