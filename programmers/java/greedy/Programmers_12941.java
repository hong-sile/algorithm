package greedy;

import java.util.Arrays;

public class Programmers_12941 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
  }

  public static int solution(int[] A, int[] B) {
    int answer = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    final int length = A.length;

    for (int i = 0; i < length; i++) {
      final int sum = A[i] * B[length - i - 1];
      answer += sum;
    }

    return answer;
  }
}
