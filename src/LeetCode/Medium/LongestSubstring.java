package LeetCode.Medium;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int result = 0;
        int start = 0;
        char[] given = new char[size];
        char[] chars;

        for (int i = 0; i < size; i++) {
            given = s.toCharArray();
        }
        while (start < size) {
            chars = new char[200];
            int ans = 0;
            for (int i = start; i < size; i++) {
                if (chars[given[i]] == 0) {
                    chars[given[i]]++;
                    ans++;
                    if (ans > result){
                        result = ans;
                    }
                } else {
                    break;
                }
            }
            start++;
        }
        return result;
    }
}
