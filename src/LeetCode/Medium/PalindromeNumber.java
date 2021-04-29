package LeetCode.Medium;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1023201));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int left = 9;
        int right = 0;
        int considerValue =x;

        while ((int) (x / Math.pow(10, left)) <= 0) {
            left--;
        }

        while (left >= right) {
            int tmpLeft = ((int)(x / Math.pow(10, left)) % 10);
            int tmpRight = considerValue % 10;
            if (tmpLeft != tmpRight) return false;
            considerValue /= 10;
            left--;
            right++;

        }
        return true;

    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int left = 9;
        int right = 0;
        int considerValue =x;

        while ((int) (x / Math.pow(10, left)) <= 0) {
            left--;
        }

        while (left >= right) {
            int tmpLeft = ((int)(x / Math.pow(10, left)) % 10);
            int tmpRight = considerValue % 10;
            if (tmpLeft != tmpRight) return false;
            considerValue /= 10;
            left--;
            right++;
        }

        return true;

    }
}
