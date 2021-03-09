package BasicAlgorithm.Practice;

//대안 1. array-> 정수변환 -> +1 -> 결과 array변환
//대안 2. 각 자릿수의 맨 뒷자리부터 +1 연산
//둘 다 시간 복잡도 공간복잡도 O(N)
// 대안 1의 경우 integer 범위를 벗어날 경우 음수 결과 나올 것 -> 대안 2로 채택
public class PlusOne {
    public static void main(String[] args) {
        int[] input = new int[]{9,9,9};
//        int[] input = new int[]{0,1,0};
//        int[] input = new int[]{9,0,9};
        int[] result = solve(input);
        for (int i: result)
        System.out.println("res :"+i);
    }
    public static int[] solve(int[] input){
        int index = input.length-1;
        int carry = 1;

        while (index >= 0) {
            int temp = input[index]+carry;
            input[index] = (temp) % 10;
            if (temp == 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            index--;
        }

        if (carry ==1){
            int[] result = new int[input.length+1];
            result[0] = 1;
            return result;
        }
        return input;
    }
}
