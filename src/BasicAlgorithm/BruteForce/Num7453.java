package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.*;

public class Num7453 {
    static int cnt;
    static Vector<Integer> aVector;
    static Vector<Integer> bVector;
    static Vector<Integer> cVector;
    static Vector<Integer> dVector;
    static long[] abSumArr;
    static long[] cdSumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cnt = Integer.parseInt(br.readLine());
        aVector = new Vector<>();
        bVector = new Vector<>();
        cVector = new Vector<>();
        dVector = new Vector<>();
        abSumArr = new long[cnt * cnt];
        cdSumArr = new long[cnt * cnt];
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {

            st = new StringTokenizer(br.readLine());
            aVector.add(Integer.parseInt(st.nextToken()));
            bVector.add(Integer.parseInt(st.nextToken()));
            cVector.add(Integer.parseInt(st.nextToken()));
            dVector.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                abSumArr[i * cnt + j] = aVector.get(i) + bVector.get(j);
                cdSumArr[i * cnt + j] = cVector.get(i) + dVector.get(j);
            }
        }

        Arrays.sort(abSumArr);
        Arrays.sort(cdSumArr);
        int limit = cnt * cnt;
        int abIndex = 0;
        int cdIndex = limit - abIndex - 1;
        long result = 0;
        while (abIndex < limit && cdIndex >= 0) {
            long abCnt = 1;
            long cdCnt = 1;
            long abSum = abSumArr[abIndex];
            long cdSum = cdSumArr[cdIndex];
            long total = abSum + cdSum;
            if (total == 0) {
                while (abIndex + 1 < limit && abSum == abSumArr[abIndex + 1]) {
                    abIndex++;
                    abCnt++;
                }
                while (cdIndex - 1 >= 0 && cdSum == cdSumArr[cdIndex - 1]) {
                    cdIndex--;
                    cdCnt++;
                }
                result += abCnt * cdCnt;
                abIndex++;
                cdIndex--;
            } else if (total > 0) cdIndex--;
            else abIndex++;
        }
        bw.write(result + "");
        bw.flush();
    }
}