package BasicAlgorithm.Practice;

import java.util.HashSet;
import java.util.Set;

public class JewelsStone {
    public static void main(String[] args) {
        String j = "aA";
        String stone = "aAABBbbB";
        System.out.println("ans: "+ solve(j, stone));
    }

    public static int solve(String jwe, String stone) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (char c : jwe.toCharArray()) {
            set.add(c);
        }
        for (char st : stone.toCharArray()) {
            if (set.contains(st)) {
                result++;
            }
        }
        return result;
    }
}
