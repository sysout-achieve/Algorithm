package LeetCode.Medium;

import java.util.Arrays;

public class Easy3 {
    public static void main(String[] args) {
        System.out.print(solution(new int[]{46, 5, 7}));
    }

    static public int solution(int[] goods) {
        Arrays.sort(goods);
        int discount = 0;
        int tempGoods = 0;
        int allSum = 0;
        for (int i = 2; i >= 0; i--) {
            allSum += goods[i];
            if (goods[i] >= 50) {
                discount++;
                continue;
            } else if (tempGoods + goods[i] >= 50) {
                discount++;
                tempGoods = 0;
            } else {
                tempGoods += goods[i];
            }
        }
        return allSum + (discount * -10);
    }
}
