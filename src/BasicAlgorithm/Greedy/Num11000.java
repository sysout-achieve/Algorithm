package BasicAlgorithm.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Num11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lectureCnt = sc.nextInt();
        int room = 0;
        int result = 0;
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < lectureCnt; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            lectures.add(new Lecture(start, 1));
            lectures.add(new Lecture(finish, -1));
        }

        lectures.sort(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.getTime() == o2.getTime()) return Integer.compare(o1.getIsStart(), o2.getIsStart());
                return Integer.compare(o1.getTime(), o2.getTime());
            }
        });

        for (int i = 0; i < lectures.size(); i++) {
            if (lectures.get(i).getIsStart() == 1) {
                room++;
                result = Math.max(room, result);
            } else {
                room--;
            }
        }
        System.out.println(result);
    }
}

class Lecture {
    int time;
    int isStart;

    public Lecture(int time, int isStart) {
        this.time = time;
        this.isStart = isStart;
    }

    public int getTime() {
        return time;
    }

    public int getIsStart() {
        return isStart;
    }

}