package Programmers.Basic;

import java.util.Arrays;

public class Num16361 {
    static String tempCard;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"})));
    }
    // 구현 문제
    // 카드 형식("-") 확인
    // "-" 제거
    // (1) 구하는 method : sum(짝수 자리 숫자) * 2
    // (2) 구하는 method : sum(홀수 자리 숫자)
    // validation check
    public static int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];
        int idx = 0;
        for(String card : card_numbers){
            int cardLeng = card.length();
            tempCard = card;
            if(!isPossible(cardLeng)){
                answer[idx] = 0;
                idx++;
                continue;
            }
            int evenSum = sum(1, tempCard);
            int oddSum = sum(0, tempCard);

            if((evenSum + oddSum)%10==0) {
                answer[idx] = 1;
            } else {
                answer[idx] = 0;
            }
            idx++;
        }
        return answer;
    }

    private static int sum(int isEven, String cardNum){
        int sum = 0;
        for(int i = cardNum.length() - 1 - isEven; i >= 0; i = i - 2){
            int temp = (cardNum.charAt(i) - '0') * (1 + isEven);
            sum += (temp/10) + (temp%10);
        }
        return sum;
    }

    private static boolean isPossible(int cardLeng){
        boolean isPossible = false;
        if(cardLeng == 16){
            if(!tempCard.contains("-")){
                isPossible = true;
            }
        } else if(cardLeng == 19){
            if(tempCard.charAt(4) == "-".charAt(0) && tempCard.charAt(9) == "-".charAt(0) && tempCard.charAt(14) == "-".charAt(0)){
                tempCard = tempCard.replace("-", "");
                if(tempCard.length() == 16){
                    isPossible = true;
                }
            }
        }
        return isPossible;
    }
}
