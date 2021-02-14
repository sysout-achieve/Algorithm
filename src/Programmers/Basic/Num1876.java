package Programmers.Basic;

import java.io.*;

//https://programmers.co.kr/learn/courses/18/lessons/1876

public class Num1876 {
    public int solution(int n) {
        String temp = String.valueOf(n);
        int answer = 0;
        for(char c : temp.toCharArray()){
            answer += c-'0';
        }
        return answer;
    }
}