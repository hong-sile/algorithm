package greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {

  private static final String INPUT_DIR = "baekJoon/java/input.txt";
  private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

  private static int N;
  private static List<Time> times = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    input();
    Collections.sort(times);

    int canCount = 0;
    long lastTime = 0;
    for (final Time time : times) {
      if (lastTime > time.start) {
        continue;
      }
      canCount++;
      lastTime = time.end;
    }
    System.out.println(canCount);
  }

  private static void input() throws Exception {
    //file io로 변경
    System.setIn(new FileInputStream(INPUT_DIR));
    System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    for (int index = 0; index < N; index++) {
      st = new StringTokenizer(br.readLine());
      final long start = Long.parseLong(st.nextToken());
      final long end = Long.parseLong(st.nextToken());
      times.add(new Time(start, end));
    }
    Collections.sort(times);
  }

  public static class Time implements Comparable<Time> {

    long start;
    long end;

    public Time(final long start, final long end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(final Time time) {
      if (this.end == time.end) {
        return Long.compare(this.start, time.start);
      }
      return Long.compare(this.end, time.end);
    }
  }
}
