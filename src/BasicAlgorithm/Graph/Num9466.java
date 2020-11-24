package BasicAlgorithm.Graph;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num9466 {
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        int[] user;
        boolean[] visit;
        while (testCase-- > 0) {
            int userCnt = Integer.parseInt(br.readLine());
            user = new int[userCnt + 1];
            visit = new boolean[userCnt + 1];
            Stack<Integer> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= userCnt; i++) {
                user[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= userCnt; i++) {
                dfs(i, user, visit, stack);
                stack.clear();
            }
            System.out.print(userCnt - res + "\n");
            res = 0;
        }
    }

    private static void dfs(int i, int[] user, boolean[] visit, Stack<Integer> stack) {
        if (stack.contains(i)) {
            while (i != stack.pop()) {
                res++;
            }
            res++;
        }
        if (visit[i]) return;
        visit[i] = true;
        stack.add(i);

        dfs(user[i], user, visit, stack);
    }
}
