package Programmers.Hash;

import java.util.HashMap;

public class Hash1 {
    public static void main(String[] args) {
    }
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashCompletion = new HashMap();
        for (int i =0; i < completion.length; i++){
            hashCompletion.put(completion[i],hashCompletion.getOrDefault(completion[i], 0)+1);
        }
        for(int i =0; i< participant.length; i++){
            int cnt = hashCompletion.getOrDefault(participant[i], 0);
            if(cnt == 0) {
                answer = participant[i];
                break;
            }
            hashCompletion.put(participant[i], cnt-1);
        }
        return answer;
    }
}
