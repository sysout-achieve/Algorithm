package BasicAlgorithm.Graph;

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
//Nhn preTEST
//https://recruit.nhn.com/pdf/%ED%94%84%EB%A6%AC%ED%85%8C%EC%8A%A4%ED%8A%B8_1%EC%B0%A8_%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C.pdf

public class Example1 {
    static int[][] map;
    static boolean[][] visited;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int islandCnt;
    static int islandNum = 0;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cnt = Integer.parseInt(br.readLine());
        Vector<Integer> resultArr = new Vector<>();
        map = new int[cnt][cnt];
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[cnt][cnt];

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    islandNum++;
                    islandCnt = 0;
                    dfs(i, j);
                    resultArr.add(islandCnt);
                }
            }
        }
        Collections.sort(resultArr);
        StringBuilder sb = new StringBuilder();
        sb.append(islandNum + "\n");
        for (int i : resultArr) {
            sb.append(i + " ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int row, int col) {
        if (visited[row][col]) return;
        visited[row][col] = true;
        islandCnt++;
        for (int i = 0; i < 4; i++) {
            int dx = col + nx[i];
            int dy = row + ny[i];
            if (dx >= 0 && dx < cnt && dy >= 0 && dy < cnt) {
                if (!visited[dy][dx] && map[dy][dx] == 1) dfs(dy, dx);
            }
        }
    }
}