package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1021 {

    //    private static final String INPUT_DIR = "baekJoon/java/input.txt";
//    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";
    static int N;
    static int M;
    static int ans;
    static LinkedList<Integer> deque = new LinkedList<>();
    static Queue<Integer> targetNumbers = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(ans);
    }

    private static void solution() {
        for (final Integer targetNumber : targetNumbers) {
            final int index = deque.indexOf(targetNumber) + 1;

            final int dequeSize = deque.size();
            final int pollLastCount = dequeSize - index + 1;
            final int pollFirstCount = index - 1;

            if (pollLastCount > pollFirstCount) {
                for (int i = 0; i < pollFirstCount; i++) {
                    final Integer pollNumber = deque.pollFirst();
                    deque.addLast(pollNumber);
                }
                deque.pollFirst();
                ans += pollFirstCount;
            } else {
                for (int i = 0; i < pollLastCount; i++) {
                    final Integer pollNumber = deque.pollLast();
                    deque.addFirst(pollNumber);
                }
                deque.pollFirst();
                ans += pollLastCount;
            }
        }
    }

    private static void input() throws IOException {
        //file io로 변경
//        System.setIn(new FileInputStream(INPUT_DIR));
//        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        for (int i = 0; i < M; i++) {
            targetNumbers.add(Integer.parseInt(st.nextToken()));
        }
    }
}
