package graph;

import static java.lang.Integer.max;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static int K;
  private static int[] builtTime;
  private static int[] totalBuiltTime;
  private static int indegree[];
  private static List<List<Integer>> graph;
  private static int targetBuilding;
  private static BufferedReader br;

  public static void main(String[] args) throws IOException {
    int T = inputTestCase();
    while (T-- != 0) {
      inputValue();
      int ans = solution();
      System.out.println(ans);
    }
  }

  private static int solution() {
    final Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      final Integer nowBuilding = queue.poll();
      totalBuiltTime[nowBuilding] += builtTime[nowBuilding];

      for (final Integer linkedNode : graph.get(nowBuilding)) {
        totalBuiltTime[linkedNode] = max(totalBuiltTime[nowBuilding], totalBuiltTime[linkedNode]);
        indegree[linkedNode] -= 1;
        if (indegree[linkedNode] == 0) {
          queue.add(linkedNode);
        }
      }
    }

    return totalBuiltTime[targetBuilding];
  }

  private static int inputTestCase() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    br = new BufferedReader(new InputStreamReader(System.in));

    final StringTokenizer st = new StringTokenizer(br.readLine());
    return Integer.parseInt(st.nextToken());
  }

  private static void inputValue() throws IOException {
    //file io로 변경
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    builtTime = new int[N];
    totalBuiltTime = new int[N];
    indegree = new int[N];
    graph = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      builtTime[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int startNode = Integer.parseInt(st.nextToken()) - 1;
      int endNode = Integer.parseInt(st.nextToken()) - 1;
      graph.get(startNode).add(endNode);
      indegree[endNode] += 1;
    }

    st = new StringTokenizer(br.readLine());
    targetBuilding = Integer.parseInt(st.nextToken()) - 1;
  }
}
