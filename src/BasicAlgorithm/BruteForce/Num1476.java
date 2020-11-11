package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Num1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        int target3 = Integer.parseInt(st.nextToken());
        int earthEnd = 15;
        int sunEnd = 28;
        int moonEnd = 19;

        int startEarth = 1;
        int startSun = 1;
        int startMoon = 1;
        int result = 1;
        while (startEarth != target1 || startSun != target2 || startMoon != target3) {
            startEarth++;
            startSun++;
            startMoon++;
            result++;
            if (startEarth > earthEnd) {
                startEarth = 1;
            }
            if (startSun > sunEnd) {
                startSun = 1;
            }
            if (startMoon > moonEnd) {
                startMoon = 1;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}