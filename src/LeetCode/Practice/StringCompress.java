package LeetCode.Practice;

public class StringCompress {
    public static void main(String[] args) {
        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(solve(input));

    }
    //대안
    // charArr 순회
    // char current, int cnt = 1
    // stringBuilder sb
    // current와 index의 char 같으면 cnt++
    //                      다르면 cnt를 sb.append
    // 순회 끝나고 나머지 sb.append
    private static String solve(char[] input) {
        int cnt = 1;
        char current = input[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length; i++) {
            if (current == input[i]) {
                cnt++;
            } else {
                sb.append(current);
                if (cnt > 1) sb.append(cnt);
                cnt = 1;
                current = input[i];
            }
        }
        sb.append(current);
        if (cnt > 1) sb.append(cnt);
        return sb.toString();
    }
}
