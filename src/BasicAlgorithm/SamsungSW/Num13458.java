package BasicAlgorithm.SamsungSW;

import java.io.*;
import java.util.StringTokenizer;

public class Num13458 {
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roomCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] room = new long[roomCnt];
        for (int i = 0; i < roomCnt; i++) {
            room[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long advisor = Integer.parseInt(st.nextToken());
        long subAdvisor = Integer.parseInt(st.nextToken());
        for (int i = 0; i < roomCnt; i++) {
            room[i] -= advisor;
            result++;
        }
        for (int i = 0; i < roomCnt; i++) {
            if (room[i] > 0) {
                result += (room[i] / subAdvisor);
                if (room[i] % subAdvisor > 0) {
                    result++;
                }
            }
        }
        bw.write(result + "");
        bw.flush();
    }
}