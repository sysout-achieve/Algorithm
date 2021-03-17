package BasicAlgorithm.Practice;

public class NumberOfIsland {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row;
    static int col;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.print(solve(grid)+"");
    }

    public static int solve(char[][] map) {
        row = map.length;
        col = map[0].length;

        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    dfs(map, visited, i, j);
                    result++;
                }
                visited[i][j] = true;
            }
        }
        return result;
    }

    public static void dfs(char[][] map, boolean[][] visited, int y, int x) {
        if (visited[y][x]) return;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( nx >= 0 && ny >= 0 && nx < col && ny < row) {
                if (!visited[ny][nx] && map[ny][nx] == '1' )
                dfs(map, visited, ny, nx);
            }
        }
    }
}
