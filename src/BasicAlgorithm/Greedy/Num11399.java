package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        int res = 0;
        int sum = 0;

        for (int i = 0; i < cnt; i++) {
            res += sum + arr.get(i);
            sum += arr.get(i);
        }
        bw.write(res + "");
        bw.flush();
    }
}