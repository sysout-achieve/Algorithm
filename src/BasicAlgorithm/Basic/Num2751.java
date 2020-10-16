package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Num2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in),8);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(bufferedReader.readLine());
        ArrayList arr = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            arr.add(num);
        }
        bufferedReader.close();
        Collections.sort(arr);
        for (int i = 0; i < cnt; i++) {
            bufferedWriter.write(arr.get(i)+"\n");
        }
        bufferedWriter.flush();
    }
}
