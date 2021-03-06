package BasicAlgorithm.Practice;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 3, 0, 2, 5, 4};
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
    //대안1. 두번의 반복문
    //size를 변수로 선언
    //Queue에 0을 제외한 숫자 저장
    //배열에 Queue에서 나오는 숫자 저장 나머지 0으로 저장
    //return 결과
    //
    //대안2. 돌면서 당기기
    //반복문을 돌면서 0이 아닐 경우에만 array에 저장
    //전체 size-index만큼 0 저장
    // 시간복잡도 O(n), 공간복잡도 O(N)

}
