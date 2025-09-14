/*
length가 1,000
100,000,000

최대 n2 log n
*/

import java.util.*;

class Solution {

  private static String answer = "";

  public String longestPalindrome(String s) {
    String[] characters = s.split("");
    StringBuilder sb = new StringBuilder();
    answer = "";

    // 홀수 케이스
    for (int i = 0; i < s.length(); i++) {
      int count = 1;
      sb = new StringBuilder();
      sb.append(characters[i]);
      while (i + count < s.length() && i - count >= 0) {
        if (characters[i - count].equals(characters[i + count])) {
          sb.insert(0, characters[i - count]);
          sb.append(characters[i + count]);
          count++;
        } else {
          break;
        }
      }
      if (answer.length() <= sb.toString().length()) {
        answer = sb.toString();
      }
    }
    // 짝수 케이스
    for (int i = 0; i < s.length() - 1; i++) {
      if (!characters[i].equals(characters[i + 1])) {
        continue;
      }
      sb = new StringBuilder();
      sb.append(characters[i]);
      sb.append(characters[i]);

      int count = 1;
      while (i + count + 1 < s.length() && i - count >= 0) {
        if (characters[i - count].equals(characters[i + 1 + count])) {
          sb.insert(0, characters[i - count]);
          sb.append(characters[i + count + 1]);
          count++;
        } else {
          break;
        }
      }
      if (answer.length() < sb.toString().length()) {
        answer = sb.toString();
      }
    }
    return answer;
  }
}