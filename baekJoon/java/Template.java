//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.util.StringTokenizer;
//
//public class Template {
//
//    private static final String INPUT_DIR = "baekJoon/java/input.txt";
//    private static final String OUTPUT_DIR = "output.txt";
//
//    public static void main(String[] args) {
//
//    }
//
//    private static void input() throws IOException {
//        //file io로 변경
//        System.setIn(new FileInputStream(INPUT_DIR));
//        System.setOut(new PrintStream(new FileOutputStream(OUTPUT_DIR)));
//
//        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        final Integer n = Integer.valueOf(st.nextToken());
//
//        for (Integer index = 0; index < n; index++) {
//            st = new StringTokenizer(br.readLine());
//            System.out.println(st.nextToken());
//        }
//    }
//}
