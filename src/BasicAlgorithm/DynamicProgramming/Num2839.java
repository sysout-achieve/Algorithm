package BasicAlgorithm.DynamicProgramming;

import java.util.Scanner;

public class Num2839 {
    public static void main(String[] args) {
        int target = new Scanner(System.in).nextInt();
        int five;
        int three;
        int sugar = target;
        five = sugar / 5;
        while (sugar != 0) {
            sugar = target;
            sugar -= five * 5;
            if (sugar % 3 == 0) {
                three = sugar / 3;
                System.out.println(three + five + "");
                return;
            }
            five--;
            if (five<0) break;
        }
        System.out.println(-1 + "");
    }
}
