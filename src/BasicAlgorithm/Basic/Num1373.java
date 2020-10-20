package BasicAlgorithm.Basic;

import java.util.Scanner;

public class Num1373 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int size = s.length();
        if (size % 3 == 1) {
            System.out.print(s.charAt(0));
        } else if (size % 3 == 2) {
            System.out.print((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));
        }
        for (int i =size%3; i<size; i+=3) {
            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i)-'0')*2 + (s.charAt(i)-'0'));
        }
    }
}


