package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Num8959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Queue<Solve> solves = new ArrayDeque<>();
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            solves.add(new Solve(str));
        }
        StringBuilder sb = new StringBuilder();
        while (!solves.isEmpty()) {
            Solve solve = solves.poll();
            int depth = 1;
            int result = 0;
            for (int i = 0; i < solve.length; i++) {
                if (solve.line.charAt(i) == 'O') {
                    result += depth;
                    depth++;
                } else {
                    depth = 1;
                }
            }
            sb.append(result + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

class Solve {
    String line;
    int length;

    public Solve(String line) {
        this.line = line;
        this.length = line.length();
    }
}