package BasicAlgorithm.Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//다시 풀어보기!!!!!!!!!!!!!!!!!!!
public class Num11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long[] nList = new long[100000];
        long maxValue = 0;
        long valueNum = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine()) - 1;
            nList[value]++;
            if (maxValue <= nList[value]) {
                valueNum = Math.min(valueNum, value);
            }
        }
        br.close();
        bufferedWriter.write((valueNum + 1) + "\n");
        bufferedWriter.flush();
    }
}