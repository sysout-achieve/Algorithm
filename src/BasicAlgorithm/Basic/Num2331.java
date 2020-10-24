package BasicAlgorithm.Basic;

import java.util.ArrayList;
import java.util.Scanner;

public class Num2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int value = sc.nextInt();
        int P = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(value);
        int finder = solve(value, P);
        while (!arr.contains(finder)) {
            arr.add(finder);
            finder = solve(finder, P);
        }

        System.out.println(arr.indexOf(finder));
    }

    static int solve(int num, int P) {
        int length = String.valueOf(num).length()-1;
        int res = 0;
        while (num != 0) {
            int holder = (int) Math.pow(10, length);
            int tmp = num / holder;
            num -= tmp*holder;
            res += Math.pow(tmp, P);
            length--;
        }
        return res;
    }
}