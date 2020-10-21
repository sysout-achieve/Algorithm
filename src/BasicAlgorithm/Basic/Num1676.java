package BasicAlgorithm.Basic;

import java.io.*;

public class Num1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int res = 0;
        for (; input >= 2; input--) {
            if (input % 125 ==0) res++;
            if (input % 25 == 0) res++;
            if (input % 5 == 0) res++;
        }

        bw.write(res + "");
        bw.flush();
    }
}