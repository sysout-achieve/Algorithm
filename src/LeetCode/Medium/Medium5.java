package LeetCode.Medium;


import java.util.Arrays;

public class Medium5 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{20, 30, 30, 50, 70, 100}, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int index = people.length - 1;
        for (int i = 0; i <= index; i++) {
            while (index > i && people[i] + people[index] > limit) {
                answer++;
                index--;
            }
            index--;
            answer++;
        }
        return answer;
    }
}