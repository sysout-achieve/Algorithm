package BasicAlgorithm.DivideConquer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Num11729 {
    static StringBuilder sb;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = new Scanner(System.in).nextInt();
        sb = new StringBuilder();
        moveHanoi(cnt, 1, 2, 3);
        bw.write(result+"\n");
        bw.write(sb.toString());
        bw.flush();
    }

    static void moveHanoi(int num, int start, int mid, int to) {
        result++;
        if (num == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        moveHanoi(num - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        moveHanoi(num - 1, mid, start, to);
    }
}