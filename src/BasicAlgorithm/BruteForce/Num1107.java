package BasicAlgorithm.BruteForce;

import java.util.Scanner;

public class Num1107 {

    static boolean[] broken = new boolean[10]; // 0~10

    static int possible(int c) {
        if (c == 0) { //0일때 예외처리
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 이동 원하는 채널
        int m = sc.nextInt(); // 고자안 채널 갯수
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true; // 트루면 고장!
        }

        int ans = Math.abs(n - 100);
        /*
         * 초기 채널은 100이다. 모든 리모콘의 숫자버튼이 고장났을 경우 +-버튼으로만이동 가능하도록 초기값을 설정해준다.
         */

        // 0부터 1000000까지 모든 채널을 돌면서 N으로 가장 적은 버튼을 눌러 이동할 수 있는 채널을 찾는다.
        for (int i = 0; i < 1000000; i++) {
            int len = possible(i);
            // len 변수: c로 숫자버튼만을 이용해서 이동이 가능한지, 가능하다면 몇 번의 버튼을 누르는지 구하는 변수
            if (len > 0) {
                int press = Math.abs(i - n);
                // press: 숫자버튼으로 n에 최대한 인접하게 이동한후 +또는 -를 몇 번 눌러야 하는지 구하는 변수
                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }
}