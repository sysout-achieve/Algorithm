package BasicAlgorithm.Basic;

import java.io.*;
//해쉬 개념
public class Num10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] list = new int[26];

        for (int i =0; i<input.length(); i++){
            char s = input.charAt(i);
            list[(((int)s+7)%26)]++;
        }
        for (int i=0; i<26; i++){
            bw.write(list[i]+" ");
        }
        bw.flush();
    }
}
