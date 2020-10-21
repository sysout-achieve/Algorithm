package BasicAlgorithm.Basic;

import java.util.Scanner;

public class Num6588 {
    static boolean[] number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        int limit = 1000000 + 1;
        number = new boolean[limit];
        for (int i = 2; i < limit; i++) {
            number[i] = true;
        }
        for (int i = 2; i < limit; i++) {
            if (!number[i]) continue;

            for (int j = 2 * i; j < limit; j += i) {
                number[j] = false;
            }
        }

        while ((value = sc.nextInt()) != 0) {
            if (goldbachOut(value)) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    static boolean goldbachOut(int num) {
        int a;
        int b;
        for (int i = 3; i < num; i += 2) {
            if (isPrime(i) && isPrime(num - i)) {
                a = i;
                b = num - i;
                System.out.println(num + " = " + a + " + " + b);
                return false;
            }
        }
        return true;
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        return number[num];
    }
}