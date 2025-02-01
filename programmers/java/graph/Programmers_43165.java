package graph;

public class Programmers_43165 {

  static int target;
  static int[] numbers;
  static int answer = 0;

  public void recursive(final int current, final int currentIndex){
    if(currentIndex == numbers.length){
      if (current == target){
        answer+=1;
      }
      return;
    }
    recursive(current+numbers[currentIndex], currentIndex+1);
    recursive(current-numbers[currentIndex], currentIndex+1);
  }

  public int solution(int[] numbers, int target) {
    Programmers_43165.target = target;
    Programmers_43165.numbers = numbers;

    recursive(0,0);

    return answer;
  }
}
