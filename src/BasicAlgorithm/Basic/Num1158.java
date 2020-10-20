package BasicAlgorithm.Basic;

import java.io.*;
import java.util.*;
import java.util.Queue;

public class Num1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int listNum = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= listNum; i++) {
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder("<");
        int std = 1;
        while (!queue.isEmpty()) {
            if (std == count) {
                sb.append(queue.remove() + ", ");
                std = 1;
            } else {
                queue.offer(queue.remove());
                std++;
            }
        }
        bw.write(sb + ">");
        bw.flush();
    }
}
