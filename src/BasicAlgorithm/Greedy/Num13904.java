package BasicAlgorithm.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Num13904 {
    public static boolean[] day;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int assignmentCnt =  scanner.nextInt();
        int result =0;
        ArrayList<Assignment> assignments = new ArrayList<>();
        int maxDay=0;
        for (int i =0; i< assignmentCnt; i++){
            int time = scanner.nextInt();
            int point = scanner.nextInt();
            assignments.add(new Assignment(time, point));
            maxDay = Math.max(maxDay, time);
        }
        day = new boolean[maxDay+1];

        assignments.sort(Assignment::compareTo);
        for (int i = 0; i< assignmentCnt; i++){
            result +=work(assignments.get(i));
        }

        System.out.println(result);
    }
    private static int work(Assignment assignment){
        for (int i =assignment.getTime(); i >0; i--){
            if (!day[i]) {
                day[i] = true;
                return assignment.getPoint();
            }
        }
        return 0;
    }

}
class Assignment implements Comparable<Assignment> {
    int time;
    int point;

    public Assignment(int time, int point) {
        this.time = time;
        this.point = point;
    }

    public int getTime() {
        return time;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public int compareTo(Assignment o) {
        if (this.point == o.getPoint()) return   this.time - o.getTime();
        return o.getPoint() - this.point;
    }
}