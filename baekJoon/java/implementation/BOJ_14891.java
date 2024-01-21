package implementation;

import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14891 {

    private static final String INPUT_DIR = "baekJoon/java/input.txt";
    private static final String OUTPUT_DIR = "baekJoon/java/output.txt";

    private static final int N = 0;
    private static final int S = 1;

    private static final int RIGHT_DIRECTION = 1;
    private static final int REVERSE_DIRECTION = -1;

    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int RIGHT_AND_LEFT = 0;

    private static final int GEAR_UP = 0;
    private static final int GEAR_RIGHT = 2;
    private static final int GEAR_LEFT = 6;

    private static final LinkedList<Integer>[] gears = new LinkedList[4];

    private static BufferedReader BR;
    private static int T;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(BR.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            turn(index - 1, direction, RIGHT_AND_LEFT);
        }
        System.out.println(calculateScore());
    }

    private static void turn(final int index, final int direction, final int indexChange) {
        if (index == -1 || index == 4) {
            return;
        }

        if (indexChange == RIGHT_AND_LEFT) {
            if (canMoveRightGear(index)) {
                turn(index + 1, direction * -1, RIGHT);
            }
            if (canMoveLeftGear(index)) {
                turn(index - 1, direction * -1, LEFT);
            }
        } else if (indexChange == RIGHT) {
            if (canMoveRightGear(index)) {
                turn(index + 1, direction * -1, RIGHT);
            }
        } else if (indexChange == LEFT) {
            if (canMoveLeftGear(index)) {
                turn(index - 1, direction * -1, LEFT);
            }
        }

        if (direction == RIGHT_DIRECTION) {
            final Integer temp = gears[index].pollLast();
            gears[index].addFirst(temp);
        } else if (direction == REVERSE_DIRECTION) {
            final Integer temp = gears[index].pollFirst();
            gears[index].addLast(temp);
        }
    }

    private static boolean canMoveRightGear(final int index) {
        if (index + 1 >= 4) {
            return false;
        }
        return gears[index].get(GEAR_RIGHT) != gears[index + 1].get(GEAR_LEFT);
    }

    private static boolean canMoveLeftGear(final int index) {
        if (index - 1 < 0) {
            return false;
        }
        return gears[index].get(GEAR_LEFT) != gears[index - 1].get(GEAR_RIGHT);
    }

    private static int calculateScore() {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].get(GEAR_UP) == S) {
                ans += pow(2, i);
            }
        }
        return ans;
    }

    private static void input() throws IOException {
        //file io로 변경
        System.setIn(new FileInputStream(INPUT_DIR));
        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));

        BR = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(BR.readLine());
            int n = Integer.parseInt(st.nextToken());
            gears[i] = new LinkedList<>();

            for (int j = 0; j < 8; j++) {
                final int number = n % 10;
                gears[i].addFirst(number);
                n = n / 10;
            }
        }

        StringTokenizer st = new StringTokenizer(BR.readLine());
        T = Integer.parseInt(st.nextToken());
    }
}
