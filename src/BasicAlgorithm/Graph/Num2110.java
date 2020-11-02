package BasicAlgorithm.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houseCnt = sc.nextInt();
        int toolCnt = sc.nextInt();
        int start = 1;
        int end;
        ArrayList<Integer> houseList = new ArrayList<>();
        for (int i = 0; i < houseCnt; i++) {
            houseList.add(sc.nextInt());
        }
        Collections.sort(houseList);
        end = houseList.get(houseCnt-1) - houseList.get(0);
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int cnt = 1;
            int prevHouse = houseList.get(0);
            for (int house : houseList) {
                if (house - prevHouse >= mid) {
                    cnt++;
                    prevHouse = house;
                }
            }
            if (cnt >= toolCnt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(end);
    }
}