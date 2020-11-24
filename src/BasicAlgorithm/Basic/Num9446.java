package BasicAlgorithm.Basic;

import java.util.Scanner;

public class Num9446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int toolCnt = sc.nextInt();
        int makeCnt = sc.nextInt();
        int[][] charge = new int[toolCnt + 1][3];
        boolean[] visit = new boolean[toolCnt + 1];
        for (int i = 1; i <= toolCnt; i++) {
            charge[i][0] = sc.nextInt();
        }
        for (int i = 0; i < makeCnt; i++) {
            int toolNum = sc.nextInt();
            int material1 = sc.nextInt();
            int material2 = sc.nextInt();
            visit[toolNum] = true;
            charge[toolNum][1] = material1;
            charge[toolNum][2] = material2;
        }
        dfs(1, charge, visit);
        System.out.print(charge[1][0] + "");
    }

    private static void dfs(int toolNum, int[][] charge, boolean[] visit) {
        if (!visit[toolNum]) return;
        visit[toolNum] = false;
        if (visit[charge[toolNum][1]]) dfs(charge[toolNum][1], charge, visit);
        if (visit[charge[toolNum][2]]) dfs(charge[toolNum][2], charge, visit);
        charge[toolNum][0] = Math.min(charge[toolNum][0], charge[charge[toolNum][1]][0] + charge[charge[toolNum][2]][0]);
    }
}

/*
5 3
        5 0 1 2 5
        5 2 3
        1 2 3
        3 2 1

5 4
5 0 1 2 3
1 3 5
3 2 1
5 2 3
5 4 3
 */