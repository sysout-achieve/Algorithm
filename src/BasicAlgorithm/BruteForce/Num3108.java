package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Num3108 {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int squareCnt = Integer.parseInt(br.readLine());
        Vector<Square> squares = new Vector<>();
        StringTokenizer st;
        boolean isZero = false;
        for (int i = 1; i <= squareCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 * x2 == 0 && y1 * y2 == 0) {
                isZero = true;
                squares.add(0, new Square(x1, y1, x2, y2, i));
            } else {
                squares.add(new Square(x1, y1, x2, y2, i));
            }
        }

        Queue<Square> q = new ArrayDeque<>();
        for (int i = 0; i < squareCnt; i++) {
            if (!squares.get(i).visited) {
                if (i != 0 || !isZero) answer++;
                q.offer(squares.get(i));
            }
            while (!q.isEmpty()) {
                Square s = q.poll();
                if (s.visited) continue;
                s.visited = true;
                for (int j = 0; j < squareCnt; j++) {
                    if (squares.get(j).visited) continue;
                    if (s.isFallen(squares.get(j))) q.offer(squares.get(j));
                }
            }

        }
        bw.write(answer + "");
        bw.flush();
    }
}

class Square {
    int x1, x2;
    int y1, y2;

    boolean visited;
    int index;

    public Square(int x1, int y1, int x2, int y2, int index) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
        this.visited = false;
        this.index = index;
    }


    public boolean isFallen(Square square) {
        int _x1 = square.x1;
        int _x2 = square.x2;
        int _y1 = square.y1;
        int _y2 = square.y2;
        int top = Math.min(y2, _y2);
        int bottom = Math.max(y1, _y1);
        int left = Math.max(x1, _x1);
        int right = Math.min(x2, _x2);
        if (top >= bottom && left <= right) {
            if (inRect(_x1, _y1) && inRect(_x2, _y2)) {
                return false;
            }
            return true;
        } else return false;
    }

    public boolean inRect(int x, int y) {
        if ((x > x1 && x < x2) && (y > y1 && y < y2))
            return true;
        else return false;
    }
}