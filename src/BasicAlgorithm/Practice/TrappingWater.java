package BasicAlgorithm.Practice;

public class TrappingWater {
    public static void main(String[] args) {
        int[] input = {0,1,0, 2,1,0, 1,3,2,1, 2,1};
        int result = solve(input);
        System.out.println(result+"");
    }

    //대안 1. min(오른쪽 벽의 높이 구하기 + 왼쪽 벽 높이 구하기) -> 본인 높이 빼기
    // 시간복잡도 O(n), 공간복잡도 O(n)

    public static int solve(int[] input){
        int length = input.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int result = 0;
        int max = 0;
        for (int i = 0; i< length; i++){
            max = Math.max(input[i], max);
            left[i] = max;
        }
         max = 0;
        for (int i = length-1; i >= 0; i--){
            max = Math.max(input[i], max);
            right[i] = max;
        }

        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - input[i];
        }
        return result;
    }
}
