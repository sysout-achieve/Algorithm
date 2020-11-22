package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long target = Integer.parseInt(br.readLine());
        int aSize = Integer.parseInt(br.readLine());
        long[] arrA = new long[aSize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        int bSize = Integer.parseInt(br.readLine());
        long[] arrB = new long[bSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        int aSumSize =getArrSize(aSize);
        int bSumSize = getArrSize(bSize);
        long[] aSum = new long[aSumSize];
        long[] bSum = new long[bSumSize];
        int index = 0;
        for (int i = 0; i < aSize; i++) {
            int sum = 0;
            for (int j = i; j < aSize; j++) {
                sum += arrA[j];
                aSum[index++] = sum;
            }
        }
        index = 0;
        for (int i = 0; i < bSize; i++) {
            int sum = 0;
            for (int j = i; j < bSize; j++) {
                sum += arrB[j];
                bSum[index++] = sum;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);
        int aIdx = 0;
        int bIdx = bSumSize - 1;
        long result = 0;
        while (aIdx < aSumSize && bIdx >= 0) {
            long a = aSum[aIdx];
            long b = bSum[bIdx];
            long aCnt = 1;
            long bCnt = 1;
            long sumAB = a + b;
            if (target == sumAB) {
                while (aIdx + 1 < aSumSize && a == aSum[aIdx + 1]) {
                    aIdx++;
                    aCnt++;
                }
                while (bIdx - 1 >= 0 && b == bSum[bIdx - 1]) {
                    bIdx--;
                    bCnt++;
                }
                result += aCnt * bCnt;
                aIdx++;
                bIdx--;
            } else if (target<sumAB){
                bIdx--;
            } else if (target>sumAB){
                aIdx++;
            }
        }
        bw.write(result+"");
        bw.flush();
    }

    static int getArrSize(int length) {
        int sum = 0;
        for (int i = 1; i <= length; i++) {
            sum += i;
        }
        return sum;
    }
}