package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Programmers_49189 {

  static int[] vertexMoveCount;

  public static void main(String[] args) {
    int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    final int ans = solution(6, edge);

    System.out.println(ans);
  }

  public static int solution(int n, int[][] edge) {
    final boolean[] visited = new boolean[n + 1];
    vertexMoveCount = new int[n + 1];

    vertexMoveCount[0] = 0;
    vertexMoveCount[1] = 0;
    final Map<Integer, List<Integer>> graph = initialMap(edge, n);

    setVertexMoveCount(visited, graph, 1);

    int max = -1;
    for (final int moveCount : vertexMoveCount) {
      max = Math.max(max, moveCount);
    }
    int ans = 0;
    for (final int moveCount : vertexMoveCount) {
      if (moveCount == max) {
        ans++;
      }
    }
    return ans;
  }

  private static void setVertexMoveCount(
      final boolean[] visited,
      final Map<Integer, List<Integer>> graph,
      final int vertexNumber
  ) {
    final Queue<Integer> queue = new LinkedList<>();
    queue.add(vertexNumber);
    visited[vertexNumber] = true;

    while (!queue.isEmpty()) {
      final Integer vertex = queue.poll();
      for (final Integer linkedVertex : graph.get(vertex)) {
        if (!visited[linkedVertex]) {
          queue.add(linkedVertex);
          vertexMoveCount[linkedVertex] = vertexMoveCount[vertex] + 1;
          visited[linkedVertex] = true;
        }
      }
    }
  }

  private static Map<Integer, List<Integer>> initialMap(final int[][] edge, final int n) {
    final Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (final int[] pair : edge) {
      graph.get(pair[0]).add(pair[1]);
      graph.get(pair[1]).add(pair[0]);
    }
    return graph;
  }
}
