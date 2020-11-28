package BasicAlgorithm.Realization;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num14889 {
    static int[][] map;
    static int startNum;
    static int cnt;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cnt = Integer.parseInt(br.readLine());
        startNum = 0;
        StringTokenizer st;
        map = new int[cnt][cnt];
        visited = new boolean[cnt];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        bw.write(result + "");
        bw.flush();
    }

    private static void solve(int start, int count) {
        if (count == cnt / 2) {
            findMin();
            return;
        }

        for (int j = start; j < cnt; j++) {
            visited[j] = true;
            solve(j + 1, count + 1);
            visited[j] = false;
        }
    }

    private static void findMin() {
        int startPoint = 0;
        int linkPoint = 0;
        ArrayList<Integer> startArr = new ArrayList<>();
        ArrayList<Integer> linkArr = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            if (visited[i]) {
                startArr.add(i);
            } else {
                linkArr.add(i);
            }
        }

        for (int i = 0; i < (cnt / 2); i++) {
            for (int j = i + 1; j < (cnt / 2); j++) {
                startPoint += map[startArr.get(i)][startArr.get(j)] + map[startArr.get(j)][startArr.get(i)];
                linkPoint += map[linkArr.get(i)][linkArr.get(j)] + map[linkArr.get(j)][linkArr.get(i)];
            }
        }

        int point = Math.abs(startPoint - linkPoint);
        if (result > point) {
            result = point;
        }
    }
}