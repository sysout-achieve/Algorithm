package Programmers.Basic;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42885
public class Num42885 {
    public static void main(String[] args) {
        int result = solution(new int[]{70,80,50,50}, 100);
        System.out.println(result+"");
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int size = people.length;

        Arrays.sort(people);
        int right = size-1;
        int left = 0;
        while ( right >= left){
            if (limit >= people[right] + people[left]){
                answer++;
                right--;
                left++;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }
}
