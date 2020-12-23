package Programmers.BruteForce;

import java.util.ArrayList;

public class BruteForce1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}));
    }
    public static int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answer1 = 0, answer2 = 0, answer3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (person1[i % person1.length] == answers[i]) answer1++;
            if (person2[i % person2.length] == answers[i]) answer2++;
            if (person3[i % person3.length] == answers[i]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2), answer3);
        ArrayList<Integer> list = new ArrayList<>();
        if (max == answer1) list.add(1);
        if (max == answer2) list.add(2);
        if (max == answer3) list.add(3);

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
