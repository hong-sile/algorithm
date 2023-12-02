package implementation;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Programmers_12951 {

  public static void main(String[] args) {
    System.out.println(solution("3people unFollowed me"));
    System.out.println(solution("for the last week"));
    System.out.println(solution("for    the last week"));
    System.out.println(solution("  for the what 1what  "));
  }

  public static String solution(final String s) {
    final String[] splitSpace = s.split(" ", -1);
    final StringBuilder sb = new StringBuilder();

    for (final String word : splitSpace) {
      final int wordLength = word.length();
      final char firstChar = word.charAt(0);

      if (Character.isLowerCase(firstChar)) {
        sb.append(Character.toUpperCase(firstChar));
      } else {
        sb.append(firstChar);
      }

      for (int i = 1; i < wordLength; i++) {
        final char c = word.charAt(i);
        if (Character.isUpperCase(c)) {
          sb.append(Character.toLowerCase(c));
        } else {
          sb.append(c);
        }
      }
      sb.append(" ");
    }

    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }
}
