package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int width = Integer.parseInt(br.readLine());
        ArrayList<Bar> barArrayList = new ArrayList<>();
        StringTokenizer st;
        int maxHeight = 0;
        int maxIndex = 0;
        int result = 0;
        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());       //좌표
            int height = Integer.parseInt(st.nextToken());       //높이
            Bar bar = new Bar(x, height);
            if (maxHeight < height) {
                maxHeight = height;
            }
            barArrayList.add(bar);
        }

        Collections.sort(barArrayList);
        for (int i = 0; i < width; i++) {
            if (maxHeight == barArrayList.get(i).height) {
                maxIndex = i;
                break;
            }
        }

        int currentHeight = 0;
        int currentX = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (currentHeight > barArrayList.get(i).height) continue;
            result += (barArrayList.get(i).x - currentX - 1) * currentHeight;
            currentHeight = barArrayList.get(i).height;
            result += currentHeight;
            currentX = barArrayList.get(i).x;
        }
        currentHeight = 0;
        currentX = 0;
        for (int i = barArrayList.size() - 1; i >= maxIndex; i--) {
            if (currentHeight > barArrayList.get(i).height) continue;
            result += (currentX - 1 - barArrayList.get(i).x) * currentHeight;
            currentHeight = barArrayList.get(i).height;
            result += currentHeight;
            currentX = barArrayList.get(i).x;
        }

        bw.write(result - maxHeight + "");
        bw.flush();
    }
}

class Bar implements Comparable<Bar> {
    int x;
    int height;

    public Bar(int x, int height) {
        this.x = x;
        this.height = height;
    }

    @Override
    public int compareTo(Bar o) {
        return x - o.x;
    }
}