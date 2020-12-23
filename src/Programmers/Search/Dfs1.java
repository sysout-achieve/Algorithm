package Programmers.Search;

public class Dfs1 {
    public int solution(int[] numbers, int target) {
       return dfs(numbers, 0, target, 0);
    }

    public int dfs(int[] numbers, int sum, int target, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, sum + numbers[index], target, index + 1)
                + dfs(numbers, sum - numbers[index], target, index + 1);
    }
}
