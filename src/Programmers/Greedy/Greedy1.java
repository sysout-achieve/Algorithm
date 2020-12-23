package Programmers.Greedy;

import java.util.Arrays;

public class Greedy1 {
    public static void main(String[] args) {
        System.out.print(solution(5, new int[]{1,3 ,5}, new int[]{4,5}));
        int[] answer = {};

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n+2];
        Arrays.fill(arr, 1);
        for (int i : lost) arr[i]--;
        for (int i : reserve) arr[i]++;
        for (int i = 1; i <= n ; i++) {
            if (arr[i] == 2) {
                if (arr[i - 1] == 0) {
                    arr[i]--;
                    arr[i - 1]++;
                } else if (arr[i + 1] == 0) {
                    arr[i]--;
                    arr[i + 1]++;
                }
            }
        }
        int lose = 0;
        for (int i : arr) {
            if (i == 0) lose++;
        }
        answer = n - lose;
        return answer;
    }
}
