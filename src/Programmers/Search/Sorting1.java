package Programmers.Search;

import java.util.Arrays;

public class Sorting1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3}, {4,4,1}, {1,7,3}}));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int cmdSize = commands.length;
        int[] answer = new int[cmdSize];
        for (int i = 0; i < cmdSize; i++) {
            answer[i] = findNum(array, commands[i][0], commands[i][1], commands[i][2]);
        }
        return answer;
    }

    public static int findNum(int[] array, int start, int end, int index) {
        int[] tempArr = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            tempArr[i - start] = array[i-1];
        }
        Arrays.sort(tempArr);
        return tempArr[index-1];
    }
}