package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num2251 {
    static int[] max = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        max[0] = Integer.parseInt(st.nextToken());
        max[1] = Integer.parseInt(st.nextToken());
        max[2] = Integer.parseInt(st.nextToken());
        bw.write(bfs(max[0], max[1], max[2]).toString());
        bw.flush();
    }

    static StringBuilder bfs(int a, int b, int c) {
        Queue<Cup> q = new ArrayDeque<>();
        Cup cup = new Cup(a, b, c);
        q.offer(cup);
        Vector<Cup> visited = new Vector<>();
        visited.add(cup);
        while (!q.isEmpty()) {
            Cup now = q.poll();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Cup tmp = new Cup(now, i, j);
                    if (!tmp.equals(now) && !visited.contains(tmp)) {
                        q.offer(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }

        Collections.sort(visited);
        StringBuilder sb = new StringBuilder();
        int k = -1;
        for (int i = 0; i < visited.size(); i++) {
            if (k == visited.get(i).contents[2]) continue;
            if (visited.get(i).contents[0] == 0) {
                k = visited.get(i).contents[2];
                sb.append(k + " ");
            }
        }
        return sb;
    }
}

class Cup implements Comparable<Cup> {
    int[] maxCnt;
    int[] contents;

    public Cup(int a, int b, int c) {
        maxCnt = new int[3];
        contents = new int[3];
        maxCnt[0] = a;
        maxCnt[1] = b;
        maxCnt[2] = c;
        contents[2] = c;
    }

    public Cup(Cup cup, int i, int j) {
        maxCnt = cup.maxCnt.clone();
        contents = cup.contents.clone();
        move(i, j);
    }

    @Override
    public boolean equals(Object obj) {
        Cup cup = (Cup) obj;
        return this.contents[0] == cup.contents[0] && this.contents[1] == cup.contents[1] && this.contents[2] == cup.contents[2];
    }

    public Cup move(int i, int j) {
        if (i != j) {
            contents[j] += contents[i];
            contents[i] = 0;
            if (contents[j] > maxCnt[j]) {
                contents[i] += contents[j] - maxCnt[j];
                contents[j] -= contents[j] - maxCnt[j];
            }
        }
        return this;
    }

    @Override
    public int compareTo(Cup o) {
        return this.contents[2] - o.contents[2];
    }
}