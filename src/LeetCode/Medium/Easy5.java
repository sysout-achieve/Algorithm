package LeetCode.Medium;


public class Easy5 {
    static int[] spelling = new int[26];
    static int max = 0;
    static int maxIndex = 0;
    static int min = Integer.MAX_VALUE;
    static int minIndex = 0;

    public static void main(String[] args) {
        System.out.print(solution("aaaabbc", 3));

    }

    public static int solution(String s, int n) {
        int result = rough(s);
        if (result == 0) return 0;
        if (spelling[minIndex] <= n) {
            n -= spelling[minIndex];
            spelling[minIndex] = 0;
        }
        while (n != 0 && result != 0) {
            if (spelling[minIndex] <= n) {
                n -= spelling[minIndex];
                spelling[minIndex] = 0;
            }
            result = find();
            if (result == 0) break;
            if (spelling[maxIndex] > 0) spelling[maxIndex]--;
            n--;
            result = find();
        }

        return result;
    }

    private static int rough(String s) {
        for (int i = 0; i < s.length(); i++) {
            spelling[s.charAt(i) - 'a']++;
        }
        return find();
    }

    private static int find() {
        for (int i = 0; i < 26; i++) {
            if (spelling[i] == 0) continue;
            if (spelling[i] > max) {
                max = spelling[i];
                maxIndex = i;
            }
            if (spelling[i] < min) {
                min = spelling[i];
                minIndex = i;
            }
        }
        return max - min;
    }
}
