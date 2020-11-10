package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Num2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int woman = Integer.parseInt(st.nextToken());
        int man = Integer.parseInt(st.nextToken());
        int internship = Integer.parseInt(st.nextToken());
        int out = 0;
        int team = 0;
        for (int i = man; i > 0; i--) {
            if (woman < 2) {
                out = i;
                break;
            }
            woman -= 2;
            team++;
        }
        out += woman;
        while (internship > out) {
            team--;
            out += 3;
        }
        bw.write(team + "");
        bw.flush();
    }
}