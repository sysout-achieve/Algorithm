package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Spot> spots = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            spots.add(new Spot(x, y));
        }
        Collections.sort(spots);
        for (int i = 0; i < cnt; i++) {
            bw.write(spots.get(i).getX() + " " + spots.get(i).getY()+"\n");
        }

        bw.flush();
    }
}

class Spot implements Comparable<Spot> {
    int x;
    int y;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Spot o) {
        if (x == o.getX()) return y - o.getY();
        return x - o.getX();
    }
}

