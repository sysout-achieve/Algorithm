package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11724 {
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visit[i] = false;
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int res =0;
        for (int i=1; i<N+1; i++){
            if (visit[i]) continue;
            dfs(i, visit);
            res++;
        }

        bw.write(res+"");
        bw.flush();
    }

    static void dfs(int start, boolean[] visit) {
        if (visit[start]) return;
        visit[start] = true;
        for (int i : arr[start]) {
            if (!visit[i]) dfs(i, visit);
        }
    }
}