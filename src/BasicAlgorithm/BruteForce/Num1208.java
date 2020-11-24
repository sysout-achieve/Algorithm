package BasicAlgorithm.BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num1208 {
    static int cnt, target;
    static int[] arr;
    static int result = 0;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSum(0, 0, cnt / 2, arr, leftList);
        makeSum(0, cnt / 2, cnt, arr, rightList);
        Collections.sort(leftList);
        Collections.sort(rightList);
        int leftIdx = 0;
        int rightIdx = rightList.size() - 1;
        while (leftIdx < leftList.size() && rightIdx >= 0) {

            int lv = leftList.get(leftIdx);
            int rv = rightList.get(rightIdx);

            if (lv + rv == target) {
                int lc = 0;
                while (leftIdx < leftList.size() && leftList.get(leftIdx) == lv) {
                    lc++;
                    leftIdx++;
                }

                int rc = 0;
                while (rightIdx >= 0 && rightList.get(rightIdx) == rv) {
                    rc++;
                    rightIdx--;
                }

                result += lc * rc;
            }

            if (lv + rv > target) rightIdx--;
            if (lv + rv < target) leftIdx++;

        }

        if (target == 0) result--; // 합계가 0인걸 찾는경우 맨 초기값이 0이므로 이 경우를 한번 빼주어야 함

        bw.write(result + "");
        bw.flush();
    }

    private static void makeSum(int value, int start, int end, int[] arr, ArrayList<Integer> list) {
        if (start >= end) {
            list.add(value);
            return;
        }

        makeSum(value + arr[start], start + 1, end, arr, list);
        makeSum(value, start + 1, end, arr, list);
    }
}