package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.*;

public class Num1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Conference> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int time = 0;
        int result = 0;

        Collections.sort(list);
        for (int i = 0; i < cnt; i++) {
            if (time <= list.get(i).start){
                result++;
                time =list.get(i).end;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}

class Conference implements Comparable<Conference> {
    int start, end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conference o) {
        if (this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}