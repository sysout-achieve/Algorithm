package LeetCode.Practice;


public class PlusOne {
    public static void main(String[] args) {
        int[] input = new int[]{9, 1, 9, 9};
        int[] result = solve(input);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // 맨 뒷자리부터 더하기
    // for()
    // 더한 값 % 10 현 위치에 저장, 값/10 -> carry
    // 반복문 종료 시점 carry가 1일 경우 List.add(0, carry);
    //return List;
    private static int[] solve(int[] input) {
        int index = input.length - 1;
        int carry = 1;
        for (int i = index; i >= 0; i--) {
            int value = input[i] + carry;
            carry = value / 10;
            input[i] = value % 10;
        }
        if (carry == 1) {
            input = new int[input.length + 1];
            input[0] = 1;
        }
        return input;
    }

}
