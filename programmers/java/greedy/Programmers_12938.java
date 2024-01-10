package greedy;

public class Programmers_12938 {

  public int[] solution(int n, int s) {
    final int[] list = new int[n];

    final int value = s / n;
    if (value == 0) {
      return new int[]{-1};
    }

    final int addMoreCount = s % n;

    int i = 0;
    for (; i < n - addMoreCount; i++) {
      list[i] = value;
    }
    for (; i < n; i++) {
      list[i] = value + 1;
    }

    return list;
  }
}
