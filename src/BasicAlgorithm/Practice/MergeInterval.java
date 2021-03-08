package BasicAlgorithm.Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    //  Input: [[2,6],[1,3],[8,10],[15,18]]
    //  Output: [[1,6],[8,10],[15,18]]
    public static void main(String[] args) {
        solve(new int[][]{{2,6},{1,3},{8,10},{15,18}});
    }

    public static int[][] solve(int[][] input) {
        Arrays.sort(input, (a,b) -> a[0] -b[0] );

        Conference before = new Conference(input[0][0],input[0][1]);
        ArrayList<Conference> conferences = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            if (before.end >= input[i][0]){
                before.end = Math.max(before.end, input[i][1]);
            } else {
                conferences.add(before);
                before = new Conference(input[i][0],input[i][1]);
            }
        }

        if (!conferences.contains(before)){
            conferences.add(before);
        }
        for (Conference con : conferences) {
            System.out.print(con.start + ", ");
            System.out.println(con.end + "");
        }
        return new int[][]{};
    }

    static class Conference{
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
