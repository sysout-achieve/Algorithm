package LeetCode.Practice;

import java.util.ArrayList;

public class MergeInterval {
    public static void main(String[] args) {
        ArrayList<Conference> input = new ArrayList<>();
        input.add(new Conference(1, 3));
        input.add(new Conference(2, 6));
        input.add(new Conference(8, 10));
        input.add(new Conference(15, 18));

        ArrayList<Conference> result = solve(input);
        for (Conference conference : result) {
            System.out.println(conference.start + " " + conference.end);
        }
    }

    //start시간으로 정렬
    //end와 start 값비교 true -> 병합
    //                 false -> 결과 리스트에 현재까지의 conference 추가
    //남은 conference 추가 후 결과 return
    //시간복잡도 O(nLogn)
    private static ArrayList<Conference> solve(ArrayList<Conference> input) {
        input.sort((a, b) -> a.start - b.start);

        ArrayList<Conference> result = new ArrayList<>();

        Conference conference = new Conference(input.get(0).start, input.get(0).end);
        for (int i = 1; i < input.size(); i++) {
            if (conference.end > input.get(i).start) {
                conference.end = Math.max(conference.end, input.get(i).end);
            } else {
                result.add(conference);
                conference = new Conference(input.get(i).start, input.get(i).end);
            }
        }
        result.add(conference);
        return result;
    }

    static class Conference {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
