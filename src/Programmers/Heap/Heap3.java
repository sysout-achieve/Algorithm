package Programmers.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap3 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})[1]);

    }
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for(String s: operations){
            if(s.startsWith("I")){
                int value = Integer.parseInt(s.substring(2));
                maxQueue.add(value);
                minQueue.add(value);
            } else {
                if(!maxQueue.isEmpty()){
                    if(s.endsWith("-1")){
                        maxQueue.remove(minQueue.poll());
                    } else {
                        minQueue.remove(maxQueue.poll());
                    }
                }
            }
        }

        if (!maxQueue.isEmpty()){
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        } else {
            answer = new int[]{0,0};
        }
        return answer;
    }
}

