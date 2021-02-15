package Programmers.Basic;

//https://programmers.co.kr/learn/courses/30/lessons/12899
public class Num12899 {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int size = 3;
        String[] arr = {"1", "2", "4"};
        while (n > 0) {
            answer.insert(0, arr[(n - 1) % size]);
            n = (n - 1) / size;
        }
        return answer.toString();
    }
}
