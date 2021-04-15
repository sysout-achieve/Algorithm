package LeetCode.Practice;

import java.util.ArrayList;
import java.util.Comparator;

public class MeetingRoom {
    public static void main(String[] args) {
        ArrayList<Meeting> input = new ArrayList<>();
        input.add(new Meeting(0, 1));
        input.add(new Meeting(15,20));
        input.add(new Meeting(2,10));

        System.out.print(solve(input)+"");
    }
    static boolean solve(ArrayList<Meeting> input){
        input.sort(Comparator.comparingInt(a -> a.start));
        int endTime = input.get(0).end;
        for (int i = 1; i < input.size(); i++) {
            if (endTime > input.get(i).start) return false;
            endTime = input.get(i).end;
        }
        return true;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }}
