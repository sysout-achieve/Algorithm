package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Num2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int[] arrA = new int[aSize];
        int[] arrB = new int[bSize];
        Vector<Integer> sumA = new Vector<>();
        Vector<Integer> sumB = new Vector<>();
        int allSize = 0;
        for (int i = 0; i < aSize; i++) {
            int size = Integer.parseInt(br.readLine());
            allSize += size;
            arrA[i] = size;
        }
        sumA.add(0);
        sumA.add(allSize);
        allSize = 0;
        for (int i = 0; i < bSize; i++) {
            int size = Integer.parseInt(br.readLine());
            allSize += size;
            arrB[i] = size;
        }
        sumB.add(0);
        sumB.add(allSize);
        int sum = 0;
        for (int i = 0; i < aSize; i++) {
            sum = arrA[i];
            sumA.add(sum);
            for (int j = i + 1; j < aSize - 1 + i; j++) {
                sum += arrA[circularIndex(j, aSize)];
                sumA.add(sum);
            }
        }
        for (int i = 0; i < bSize; i++) {
            sum = arrB[i];
            sumB.add(sum);
            for (int j = i + 1; j < bSize - 1 + i; j++) {
                sum += arrB[circularIndex(j, bSize)];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        aSize = sumA.size();
        bSize = sumB.size();
        int indexA = 0;
        int indexB = 0;
        int result = 0;
        while (indexA < aSize && indexB < bSize) {
            int aCnt = 1;
            int bCnt = 1;
            int aSum = sumA.get(indexA);
            int bSum = sumB.get(indexB);
            int abSum = aSum + bSum;
            if (abSum == target) {
                while (indexA + 1 < aSize && sumA.get(indexA + 1) == aSum) {
                    indexA++;
                    aCnt++;
                }
                while (indexB + 1 < bSize && sumB.get(indexB + 1) == bSum) {
                    indexB++;
                    bCnt++;
                }
                result += aCnt * bCnt;
                indexA++;
                indexB++;
            } else if (abSum > target) {
                indexB++;
            } else {
                indexA++;
            }
        }
        bw.write(result + "");
        bw.flush();
    }

    static int circularIndex(int i, int size) {
        return i % size;
    }
}