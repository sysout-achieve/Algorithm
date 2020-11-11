package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.*;

public class Num1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Stack<Integer> positiveList = new Stack<>();
        Stack<Integer> negativeList = new Stack<>();
        int result = 0;
        boolean containZero = false;
        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value < 0) {
                negativeList.add(value);
            } else if (value == 0) {
                containZero = true;
            } else if (value == 1) {
                result++;
            } else {
                positiveList.add(value);
            }
        }
        Collections.sort(negativeList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(positiveList);

        while (!positiveList.isEmpty()) {
            int value1 = positiveList.pop();
            if (positiveList.isEmpty()){
                result+=value1;
                break;
            }
            int value2 = positiveList.pop();
            result += value1*value2;
        }
        while (!negativeList.isEmpty()) {
            int value1 = negativeList.pop();
            if (negativeList.isEmpty()){
                if (containZero){
                    break;
                }
                result+=value1;
                break;
            }
            int value2 = negativeList.pop();
            result += value1*value2;
        }

        bw.write(result+"");
        bw.flush();
    }
}