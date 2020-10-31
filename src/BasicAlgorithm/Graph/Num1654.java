package BasicAlgorithm.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lineCnt = Integer.parseInt(st.nextToken());
        int needLine = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lineCnt; i++) {
            int length = Integer.parseInt(br.readLine());
            arr.add(length);
        }
        long minLength = 0;
        long maxLength;
        long sum = 0;
        for (int i = 0; i < lineCnt; i++) {
            sum += arr.get(i);
        }
        maxLength = sum / lineCnt;
        int temp;
        long mid = maxLength;
        while (maxLength >= minLength) {
            temp = 0;
            for (int i = 0; i < lineCnt; i++) {
                temp += arr.get(i) / mid;
            }
            if (temp >= needLine) {
                minLength = mid + 1;
            } else {
                maxLength = mid - 1;
            }
            mid = (maxLength + minLength) / 2;
        }
        bw.write(minLength + "");
        bw.flush();
    }
}