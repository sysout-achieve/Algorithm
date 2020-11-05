package BasicAlgorithm.Graph;

import java.io.*;
import java.util.StringTokenizer;

public class Num11662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point minhoStart = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point minhoEnd = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point kangStart = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point kangEnd = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point minhoMid = midPoint(minhoStart, minhoEnd);
        Point kangMid = midPoint(kangStart, kangEnd);
        double distanceStart = distance(minhoStart, kangStart);
        double distanceEnd = distance(minhoEnd, kangEnd);
        double distanceMid = distance(minhoMid, kangMid);
        if (distanceMid < distanceStart) {
            minhoStart = minhoMid;
            kangStart = kangMid;
        }
        if (distanceMid < distanceEnd){
            minhoEnd = minhoMid;
            kangEnd = kangMid;
        }
        double maxDistance = Math.max(distanceStart, distanceEnd);
        double minDistance = Math.min(distanceStart, distanceEnd);
        double avrDistance = Math.min(distanceStart, distanceEnd);
        double distance = minDistance;

        while (minDistance < maxDistance) {
            distance = minDistance;
            if (distanceEnd <= distanceStart) {
                minhoEnd = midPoint(minhoStart, minhoEnd);
                kangEnd = midPoint(kangStart, kangEnd);
            } else {
                minhoStart = midPoint(minhoStart, minhoEnd);
                kangStart = midPoint(kangStart, kangEnd);
            }
        }

        bw.write(distance + "");

        bw.flush();
    }


    static Point currentPoint(Point start, Point end) {
        return new Point(end.x - start.x, end.y - start.y);
    }

    static Point midPoint(Point start, Point end) {
        return new Point((end.x + start.x) / 2, (end.y - start.y / 2));
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow(p1.x - p2.x, 2)) + (Math.pow(p1.y - p2.y, 2)));
    }
}

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}