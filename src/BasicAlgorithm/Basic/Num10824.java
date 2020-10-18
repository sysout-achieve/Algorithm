package BasicAlgorithm.Basic;

import java.io.*;
import java.util.StringTokenizer;

public class Num10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long first, last;
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        first = Long.parseLong(str1 + str2);
        String str3 = st.nextToken();
        String str4 = st.nextToken();
        last = Long.parseLong(str3 + str4);
        bw.write((first+last)+"");

        bw.flush();
    }
}
