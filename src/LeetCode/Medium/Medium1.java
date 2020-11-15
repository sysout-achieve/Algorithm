package LeetCode.Medium;

public class Medium1 {
    public int solution(int n, int a, int b) {
        int user1 = Math.min(a, b);
        int user2 = Math.max(a, b);
        int answer =1;
        while (n != 1) {
            if (user1 % 2 == 1 && user2 - user1 == 1) {
                break;
            }
            n = n / 2;
            answer++;
            user1 = user1/2 +user1%2;
            user2 = user2/2 +user2%2;
        }
        return answer;
    }
}
