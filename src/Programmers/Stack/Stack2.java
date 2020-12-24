package Programmers.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Stack2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i =0; i<progresses.length; i++){
            int day =
                    (100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : ((100-progresses[i])/speeds[i])+1;
            q.offer(day);
        }
        int fun = 1;
        int day = q.poll();

        while(!q.isEmpty()){
            int needWorkDay = q.poll();
            if(needWorkDay <= day){
                fun++;
            } else {
                day = needWorkDay;
                ansList.add(fun);
                fun = 1;
            }
        }
        answer= new int[ansList.size()];
        for(int i =0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
