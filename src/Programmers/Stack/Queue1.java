package Programmers.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0;
        Queue<Integer> bridgeQueue = new ArrayDeque<>();

        //모든 트럭을 다리위에 올리기 위한 for문
        for(int truck : truck_weights){
            while(true){
                if(bridgeQueue.size() == bridge_length) {   //다리에 트럭이 들어갈 수 없는 경우(공간이 없을 경우)
                    current_weight-=bridgeQueue.poll();
                } else if(current_weight+truck <= weight){  //다음 트럭이 올라올 수 있는 경우
                    bridgeQueue.offer(truck);
                    current_weight+=truck;
                    answer++;
                    break;
                } else {                                    //트럭이 올라오지 못하고 시간만 지나가는 경우
                    bridgeQueue.offer(0);
                    answer++;
                }
            }
        }

        //모든 트럭이 다리 위에 올라온 이후 다리를 지나가는 시간을 더한 결과
        return answer+bridge_length;
    }
}
