package LeetCode.Medium;

//https://leetcode.com/problems/hamming-distance/
public class HammingDistance {
    // 1. x 와 y XOR연산 -> ex) 10000 ^ 1 = 10001
    // 2. return 10001 에서 0 갯수;

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (xor >> i) & 1;
        }
        return result;
    }
}
