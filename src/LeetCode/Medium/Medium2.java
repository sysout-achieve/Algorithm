package LeetCode.Medium;

import java.util.ArrayList;

public class Medium2 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 15};

        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int time = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            arr.add(day);
        }
        for (int i = 0; i < size; ) {
            time += arr.get(i);
            int update = 0;
            for (int j = i; j < size; j++) {
                if (time >= arr.get(j)) {
                    i++;
                    update++;
                } else break;
            }
            ansList.add(update);
        }
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}
