package LeetCode.Medium;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cardog","caracecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            for (int j = result.length(); j >= 0; j--) {
                result = result.substring(0, j);
                if (strs[i].startsWith(result)) {
                    break;
                }
            }
        }
        return result;
    }
}
