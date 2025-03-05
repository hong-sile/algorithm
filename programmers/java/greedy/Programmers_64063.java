package greedy;

import java.util.HashMap;
import java.util.Map;

class Programmers_64063 {

  Map<Long,Long> totalRoom = new HashMap<>();

  public long find(long index){
    totalRoom.putIfAbsent(index,index);
    if(totalRoom.get(index) != index){
      totalRoom.put(index, find(totalRoom.get(index)));
    }
    return totalRoom.get(index);
  }

  public void union(long newElement, long exsistElement){
    long existRoot = find(exsistElement);
    long newRoot = find(newElement);


    totalRoom.put(existRoot, newRoot);
    totalRoom.put(newElement, newRoot);

  }

  public long[] solution(long k, long[] room_number) {
    int index = 0;
    long[] answer = new long[room_number.length];

    for(long roomNumber : room_number){
      long assigned = find(roomNumber);
      answer[index] = assigned;
      union(assigned + 1, roomNumber);
      index += 1;
    }

    return answer;
  }

}
