package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 아이디어 못 떠올린 문제 힌트를 보고 나서 감을 잡음 다음에 다시 풀어보자
 */
public class BOJ_1167 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static List<List<Node>> graph;
  private static boolean[] visited;
  private static int[] dists;
  private static int N;

  public static void main(String[] args) throws IOException {
    input();
    dijkstra(1);

    int maxIndex = 1;
    for (int i = 1; i <= N; i++) {
      maxIndex = (dists[i] > dists[maxIndex]) ? i : maxIndex;
    }

    dijkstra(maxIndex);

    int maxLength = 1;
    for (int i = 1; i <= N; i++) {
      maxLength = Integer.max(maxLength, dists[i]);
    }

    System.out.println(maxLength);
  }

  private static void dijkstra(int currentIndex) {
    visited = new boolean[N + 1];
    dists = new int[N + 1];
    Arrays.fill(dists, Integer.MAX_VALUE);

    final PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(currentIndex, 0));

    dists[currentIndex] = 0;

    while (!pq.isEmpty()) {
      final Node currentNode = pq.poll();
      final int linkedVertex = currentNode.vertex;

      if (!visited[linkedVertex]) {
        visited[linkedVertex] = true;

        for (final Node node : graph.get(linkedVertex)) {
          if (!visited[node.vertex] && dists[node.vertex] > dists[linkedVertex] + node.length) {
            dists[node.vertex] = dists[linkedVertex] + node.length;
            pq.add(new Node(node.vertex, dists[node.vertex]));
          }
        }
      }
    }
  }

  private static void input() throws IOException {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int index = 0; index < N; index++) {
      final Queue<Integer> inputEdge = Arrays.stream(br.readLine().split(" "))
          .map(Integer::valueOf)
          .collect(Collectors.toCollection(LinkedList::new));

      final Integer vertex = inputEdge.poll();

      while (inputEdge.peek() != -1) {
        final int linkedVertex = inputEdge.poll();
        final int length = inputEdge.poll();
        final Node node = new Node(linkedVertex, length);
        graph.get(vertex).add(node);
      }
    }
  }

  static class Node implements Comparable<Node> {

    final int vertex;
    final int length;

    public Node(final int vertex, final int length) {
      this.vertex = vertex;
      this.length = length;
    }

    @Override
    public int compareTo(final Node node) {
      return length - node.length;
    }
  }
}