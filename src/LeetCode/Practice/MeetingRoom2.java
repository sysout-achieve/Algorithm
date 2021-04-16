package LeetCode.Practice;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        ArrayList<Meeting> input = new ArrayList<>();
        input.add(new Meeting(0,30));
        input.add(new Meeting(4,9));
        input.add(new Meeting(5,15));
        input.add(new Meeting(10,20));
        input.add(new Meeting(15,25));

        System.out.println(solve(input));
    }

    private static int solve(ArrayList<Meeting> input) {
        input.sort((a,b)-> a.start - b.start);
        Queue<Meeting> q = new PriorityQueue<>((a,b)-> a.end - b.end);
        q.offer(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            if(q.peek().end <= input.get(i).start){
                q.poll();
            }
            q.offer(input.get(i));
        }
        return q.size();
    }

    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
