package BasicAlgorithm.Basic;

import java.util.Scanner;

public class Num10451 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] arr;
        boolean[] visit;
        while (testCase-- > 0) {
            int cnt = sc.nextInt();
            int res = 0;
            arr = new int[cnt+1];
            visit = new boolean[cnt+1];
            for (int i = 1; i <= cnt; i++) {
                int input = sc.nextInt();
                arr[i] = input;
            }

            for (int i=1; i<=cnt;i++){
                if (!visit[i]) {
                    dfs(i, arr, visit);
                    res++;
                }
            }
            System.out.print(res+"\n");
        }
    }

    private static void dfs(int i, int[] arr, boolean[] visit) {
        if (visit[i]) return;
        visit[i] = true;
        dfs(arr[i], arr, visit);
    }
}