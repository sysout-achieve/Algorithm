package LeetCode.Medium;

import java.io.*;
import java.util.*;

public class Medium6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
    }

    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for (int i :numbers){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a1 = String.valueOf(o1);
                String a2 = String.valueOf(o2);
                return Integer.valueOf(a1+a2) - Integer.valueOf(a2+a1);
            }
        });

        for (int i =0; i<list.size(); i++){
            answer +=String.valueOf(list.get(i));
        }

        return answer;
    }
}