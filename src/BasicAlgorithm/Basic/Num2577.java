package BasicAlgorithm.Basic;

import java.io.*;

public class Num2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int value = a*b*c;
        String valueStr = String.valueOf(value);
        int size = valueStr.length();

        for (int i =0; i<size; i++){
           int result = valueStr.charAt(i) -'0';
           arr[result]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<10; i++){
            sb.append(arr[i]+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}