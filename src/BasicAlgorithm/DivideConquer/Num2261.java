package BasicAlgorithm.DivideConquer;

import java.io.*;
import java.util.*;

public class Num2261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        StringTokenizer st;
        for (int i =0; i<cnt;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x,y));
        }
        Collections.sort(points);
        int res = closest(points, 0, cnt-1);
        bw.write(res+"");
        bw.flush();
    }

    private static int dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static int bruteForce(List<Point> list, int x, int y) {
        int ans = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            for (int j = i + 1; j <= y; j++) {
                int k = dist(list.get(i), list.get(j));
                if (ans > k) {
                    ans = k;
                }
            }
        }
        return ans;
    }

    private static int closest(List<Point> list, int x, int y) {
        int n = y - x + 1;
        if (n <= 3) {
            return bruteForce(list, x, y);
        }
        int mid = (x + y) / 2;
        int left = closest(list, x, mid);
        int right = closest(list, mid + 1, y);
        int ans = Math.min(left, right);

        List<Point> b = new ArrayList<>();
        for (int i = x; i < y; i++) {
            int d = list.get(i).x - list.get(mid).x;
            if (d * d < ans) {
                b.add(list.get(i));
            }
        }
        Collections.sort(b, new PointComparator());
        int m = b.size();
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int k = b.get(i).y-b.get(j).y;
                if (k*k<ans){
                    int d = dist(b.get(i), b.get(j));
                    if (d<ans){
                        ans = d;
                    }
                } else{
                    break;
                }
            }
        }
        return ans;
    }

}


class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o1.y - o2.y;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        int res = this.x - o.x;
        if (res == 0) return this.y - o.y;
        return res;
    }
}