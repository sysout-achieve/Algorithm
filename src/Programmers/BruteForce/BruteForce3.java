package Programmers.BruteForce;

import java.util.ArrayList;

public class BruteForce3 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        ArrayList<Integer> arr = new ArrayList();

        for(int i =1; i<=sum; i++){
            if(sum%i==0) {
                arr.add(i);
            }
        }
        for (Integer a : arr) {
            for (Integer b : arr) {
                if (a >= b) {
                    if (a * b == sum) {
                        if ((a - 2) * (b - 2) == yellow) {
                            return new int[]{a, b};
                        }
                    }
                }
            }
        }
        return null;
    }
}
