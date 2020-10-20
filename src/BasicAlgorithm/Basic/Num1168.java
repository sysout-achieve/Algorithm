package BasicAlgorithm.Basic;

import java.util.Scanner;
import java.util.Vector;

public class Num1168 {
    public static void main(String[] args) {
        Scanner scan2 = new Scanner(System.in);
        int N = scan2.nextInt();
        int K = scan2.nextInt();
        StringBuilder SB = new StringBuilder();
        Vector<Integer> v = new Vector<>();

        for (int i = 1; i <= N; i++) v.add(i);

        int now = K - 1;
        while (true) {
            SB.append(v.get(now));
            v.remove(now);
            if (v.size() == 0) break;
            SB.append(", ");
            now += K - 1;
            now %= v.size();
        }
        System.out.println("<" + SB + ">");
    }
}
