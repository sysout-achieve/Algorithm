package Programmers.BruteForce;

//두 개 뽑아서 더하기
// https://programmers.co.kr/learn/courses/30/lessons/68644
import java.util.*;

public class BruteForce2 {
    public int[] solution(int[] numbers) {
        //중복없는 오름차순 정렬 배열을 위한 TreeSet
        Set<Integer> sumNumber = new TreeSet<>();

        //2가지 값을 더하는 모든 경우의 수를 TreeSet에 추가
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumNumber.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[sumNumber.size()];
        int index = 0;
        //answer 배열에 순차적으로 넣고 결과값 return
        Iterator itor = sumNumber.iterator();
        while (itor.hasNext()) {
            answer[index] = (int) itor.next();
            index++;
        }
        return answer;
    }
}