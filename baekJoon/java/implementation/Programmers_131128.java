package implementation;

public class Programmers_131128 {

  final static int[] intCount = new int[10];

  public static String solution(String X, String Y) {
    for (int i = 0; i < 10; i++) {
      final int XCount = X.split(String.valueOf(i), -1).length - 1;
      final int YCount = Y.split(String.valueOf(i), -1).length - 1;

      final int count = Math.min(XCount, YCount);

      intCount[i] = count;
    }

    final StringBuilder ansBuilder = new StringBuilder();

    for (int i = 9; i >= 0; i--) {
      for (int j = 0; j < intCount[i]; j++) {
        ansBuilder.append(i);
      }
    }

    final String ans = ansBuilder.toString();
    if (ans.isBlank()) {
      return "-1";
    }
    return ans;
  }
}
