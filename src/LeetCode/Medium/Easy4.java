package LeetCode.Medium;

public class Easy4 {
    public static void main(String[] args) {
//        System.out.print(solution());
    }
    static public int solution(int page, int[] broken){
        int result = Math.abs(page - 100);
        boolean[] isBroken = new boolean[10];
        for (int i = 0; i < broken.length; i++) {
            isBroken[broken[i]] = true;
        }
        for (int i = 0; i < 1000000; i++) {
            int cnt = possible(i, isBroken);
            if (cnt > 0) {
                int press = Math.abs(i - page);
                if (result > cnt + press) {
                    result = cnt + press;
                }
            }
        }
        return result;
    }

    static int possible(int c, boolean[] isBroken) {
        if (c == 0) {
            if (isBroken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int cnt = 0;
        while (c > 0) {
            if (isBroken[c % 10]) {
                return 0;
            }
            cnt += 1;
            c /= 10;
        }
        return cnt;
    }
}
