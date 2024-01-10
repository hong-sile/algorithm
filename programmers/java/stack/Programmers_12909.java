package stack;

public class Programmers_12909 {

  public static void main(String[] args) {
    System.out.println(solution("()()"));
    System.out.println(solution("(())()"));
    System.out.println(solution(")()("));
    System.out.println(solution("(()("));
  }

  static boolean solution(String s) {
    int sum = 0;

    for (final char bracket : s.toCharArray()) {
      if (bracket == '(') {
        sum += 1;
      } else if (bracket == ')') {
        if (sum == 0) {
          return false;
        }
        sum -= 1;
      }
    }
    return sum == 0;
  }
}
