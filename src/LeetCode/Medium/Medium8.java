package LeetCode.Medium;

public class Medium8 {
    public static void main(String[] args) {
        System.out.print(solution("21378"));
    }

    static public String solution(String cardNumber) {
        int length = cardNumber.length();
        int[] cardNum = new int[length+1];
        if (length % 2 == 0) {
            for (int i = 1; i <= length; i++) {
                int num = cardNumber.charAt(i-1) - '0';
                if (i % 2 == 1) {
                    cardNum[i] = num * 2;
                } else {
                    cardNum[i] = num;
                }
            }
        } else {
            for (int i = 1; i <= length; i++) {
                int num = cardNumber.charAt(i-1) - '0';
                if (i % 2 == 1) {
                    cardNum[i] = num;
                } else {
                    cardNum[i] = num * 2;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= length; i++) {
            result += cardNum[i] % 10 + cardNum[i] / 10;
        }
        StringBuilder sb = new StringBuilder();
        if (result%10== 0) sb.append("VALID");
        else sb.append("INVALID");
        return sb.toString();
    }
}
