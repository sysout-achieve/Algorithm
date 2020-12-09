package LeetCode.Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for(int j = i+1 ; j < height.length; j++){
                int min = Math.min(height[i], height[j]);
                int temp = ( j - i ) * min;
                if(temp>result){
                    result = temp;
                }
            }
        }
        return result;
    }
}
