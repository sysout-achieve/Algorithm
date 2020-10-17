package BasicAlgorithm.Basic;

import java.io.*;

public class Num9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String text = br.readLine();
            int vps = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == ('(')) {
                    vps++;
                } else if (text.charAt(j) == (')')) {
                    vps--;
                }

                if (vps < 0) {
                    bw.write("NO");
                    bw.newLine();
                    break;
                }
            }

            if (vps == 0) {
                bw.write("YES");
                bw.newLine();
            } else if (vps > 0) {
                bw.write("NO");
                bw.newLine();
            }

        }
        bw.flush();
    }
}