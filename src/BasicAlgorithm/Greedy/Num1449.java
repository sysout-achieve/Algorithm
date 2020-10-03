package BasicAlgorithm.Greedy;

import java.util.*;

public class Num1449 {
    private static int tapeCnt = 0;
    private static int coverMaxNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> holeNumList = new ArrayList<>();
        int holes = sc.nextInt();
        int tapeLength = sc.nextInt();
        for (int i = 0; i < holes; i++) {
            holeNumList.add(sc.nextInt());
        }
        Collections.sort(holeNumList);
        for (int i = 0; i < holeNumList.size(); i++) {
            if (holeNumList.get(i) > coverMaxNum) {
                cover(tapeLength, holeNumList, i);
            }
        }
        System.out.println(tapeCnt);

    }
    private static void cover(int tapeLength, ArrayList<Integer> list, int index) {
        coverMaxNum = tapeLength - 1 + list.get(index);
        tapeCnt++;
    }
}
