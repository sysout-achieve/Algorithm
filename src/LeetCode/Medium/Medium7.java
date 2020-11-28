package LeetCode.Medium;


public class Medium7 {
    static int[] w = {10, 20, 30};
    static int[] v = {60, 100, 120};
    static int k = 50;
    static int length;
    static int result = 0;

    public static void main(String[] args) {
        System.out.print(knapsack(w, v, k));
    }

    public static int knapsack(int[] w, int[] v, int k) {
        length = w.length;
        solve(0, 0, 0);
        return result;
    }

    private static void solve(int index, int weight, int value) {
        if (weight > k || length < index) {
            return;
        }
        result = Math.max(value, result);
        if (index + 1 <= length) {
            solve(index + 1, weight + w[index], value + v[index]);
        }
        solve(index + 1, weight, value);
    }
}
