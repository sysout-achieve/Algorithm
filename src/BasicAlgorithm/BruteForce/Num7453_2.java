package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

//소팅할때 Collections.sort 대신 Arrays.sort를 사용해야 합니다.
//이유는 소팅에서 primitive type의 경우 dual pivot quicksort가 수행되는데 non primitive type은 merge sort가 수행이 되요.
//참조지역성으로 인해 merge sort에서는 캐시 히트율이 떨어져 퀵소트보다 느립니다.
public class Num7453_2 {        //시간초과
    static int cnt;
    static Vector<Integer> aVector;
    static Vector<Integer> bVector;
    static Vector<Integer> cVector;
    static Vector<Integer> dVector;
    static Vector<Long> abVector;
    static Vector<Long> cdVector;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cnt = Integer.parseInt(br.readLine());
        aVector = new Vector<>();
        bVector = new Vector<>();
        cVector = new Vector<>();
        dVector = new Vector<>();
        abVector = new Vector<>();
        cdVector = new Vector<>();
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
                abVector.add((long) (aVector.get(i) + bVector.get(j)));
                cdVector.add((long) (cVector.get(i) + dVector.get(j)));
            }
        }

        Arrays.sort(abVector.toArray());
        Arrays.sort(cdVector.toArray());
        int limit = cnt * cnt;
        int abIndex = 0;
        int cdIndex = 0;
        int result = 0;
        while (abIndex < limit && cdIndex < limit) {
            int abCnt = 1;
            int cdCnt = 1;
            long abSum = abVector.get(abIndex);
            long cdSum = cdVector.get(cdIndex);
            long total = abSum + cdSum;
            while (abIndex+1 < limit && abSum == abVector.get(abIndex+1)) {
                abIndex++;
                abCnt++;
            }

            while (cdIndex+1 < limit && cdSum == cdVector.get(cdIndex+1)) {
                cdIndex++;
                cdCnt++;
            }
            if (total == 0) {
                result += abCnt * cdCnt;
                abIndex++;
                cdIndex++;
            }
            else if (total > 0) cdIndex++;
            else abIndex++;

        }
        bw.write(result + "");

        bw.flush();
    }
}