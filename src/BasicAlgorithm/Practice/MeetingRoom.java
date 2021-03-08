package BasicAlgorithm.Practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom {
    public static void main(String[] args) {
        Meeting m1 = new Meeting(0,30);
        Meeting m2 = new Meeting(5,15);
        Meeting m3 = new Meeting(4,9);
        Meeting m4 = new Meeting(10,16);
        Meeting[] meetings = new Meeting[]{m1, m2, m3, m4};
        System.out.println(solve(meetings)+"");
    }

    static int solve(Meeting[] meetings) {
        if (meetings == null || meetings.length == 0) return 0;
        Arrays.sort(meetings, (a, b) -> a.start - b.start);
        Queue<Meeting> priorityQueue = new PriorityQueue<>((a, b) -> a.end - b.end);
        priorityQueue.offer(meetings[0]);
        for (int i = 1; i< meetings.length; i++) {
            if (priorityQueue.peek().end <= meetings[i].start) {
                priorityQueue.poll();
            }
            priorityQueue.offer(meetings[i]);
        }
        return priorityQueue.size();
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
