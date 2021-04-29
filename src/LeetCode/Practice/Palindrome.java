package LeetCode.Practice;

public class Palindrome {
    public static void main(String[] args) {
        String input = "abccdqdccba";
        System.out.println(solve(input));
    }

    //1. 문자열 뒤집어서 같은지 확인
    // 시간복잡도 O(n)

    //2. 순회할때 i , length - 1 - i
    // i > length - 1 - i
    //  시간복잡도 O(n)
    private static boolean solve(String input) {
        char[] chars = input.toCharArray();
        int leng = chars.length;
        for (int i = 0; i < leng/2 ; i++) {
            if(chars[i] != chars[leng - 1 - i]) return false;
        }
        return true;
    }
}
