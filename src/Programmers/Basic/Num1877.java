package Programmers.Basic;

//https://programmers.co.kr/learn/courses/18/lessons/1877
public class Num1877 {
    public boolean solution(int[] arr) {
        int size = arr.length;
        int[] res = new int[size+1];
        try{
            for (int j : arr) {
                res[j]++;
            }
        } catch(Exception e){
            return false;
        }
        for(int i =1; i<size; i++){
            if(res[i]!=1) return false;
        }
        return true;
    }
}
