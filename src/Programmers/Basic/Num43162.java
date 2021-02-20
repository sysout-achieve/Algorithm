package Programmers.Basic;

public class Num43162 {
    static boolean[] visited;
    static int[][] computerList;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computerList = computers;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, n);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int idx, int n){
        visited[idx] = true;
        for(int i = 0; i < n; i++){
            if(computerList[idx][i] == 1 && !visited[i]){
                dfs(i, n);
            }
        }
    }
}
