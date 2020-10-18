package BasicAlgorithm.Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


//다시 풀어보기!!!!!!!!!!!!!!!!!!!
public class Num10989 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nList = new int[10000];
        for (int i = 0; i < n; i++) {
            nList[Integer.parseInt(br.readLine())-1]++;
        }
        br.close();
        for (int i = 0; i < 10000; i++) {
            for(int j = 0;j < nList[i];j++) {
                bufferedWriter.write((i+1)+"\n");
            }
        }
        bufferedWriter.flush();
    }
}