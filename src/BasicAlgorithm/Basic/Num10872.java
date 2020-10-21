package BasicAlgorithm.Basic;

import java.io.*;

public class Num10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int result =1;
        for (; input>=2; input--){
            result*=input;
        }
        bw.write(result+"");
        bw.flush();
    }
}