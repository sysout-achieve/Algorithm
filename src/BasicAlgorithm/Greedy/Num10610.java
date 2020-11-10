package BasicAlgorithm.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Num10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String valueStr = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        boolean isContainZero = false;
        for (int i = 0; i < valueStr.length(); i++) {
            int number = valueStr.charAt(i) - '0';
            arr.add(number);
            sum += number;
            if (number == 0) isContainZero = true;
        }
        if (!isContainZero || sum % 3 != 0) {
            bw.write(-1 + "");
        } else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(arr);
            for (int i = arr.size() - 1; i >= 0; i--) {
                sb.append(arr.get(i));
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }
}