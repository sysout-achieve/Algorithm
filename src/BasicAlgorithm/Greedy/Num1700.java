package BasicAlgorithm.Greedy;

/*
test
3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Num1700 {
//    private static int used = 0;
//    private static int result = 0;
//    private static int[] tabs;
//    private static int[] toolUsing;
//    private static ArrayList<Integer> tools = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int tabCnt = scanner.nextInt();
//        int toolCnt = scanner.nextInt();
//        tabs = new int[tabCnt];
//        toolUsing = new int[toolCnt + 1];
//        for (int i = 1; i <= toolCnt; i++) {
//            int toolNum = scanner.nextInt();
//            tools.add(toolNum);
//            toolUsing[i]++;
//        }
//
//        for (int i = 0; i < tools.size(); i++) {
//            if (tabCnt > used) {
//                addPlug(i);
//            } else {
//                for (int j = 0; j < tabCnt; j++) {
//                    if (toolUsing[tabs[j]] == 0) {
////                        int toolNum = tools.get(i);
//                        tabs[j] = 0;
//                        used--;
//                        result++;
//                    }
//                }
//            }
//        }
//    }
//
//    private static void addPlug(int index) {
//        int toolNum = tools.get(index);
//        tabs[used] = toolNum;
//        toolUsing[toolNum]--;
//        used++;
//    }


}

class Tool {
    int toolNum;
    int times;

    public Tool(int toolNum) {
        this.toolNum = toolNum;
    }
}