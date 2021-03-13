package BasicAlgorithm.Practice;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int[] input = {2, 3, 5, 50,60,61,63, 75};
        int lower = 0, upper = 99;
        List<String> result = solve(input, lower, upper);
        System.out.println(result);

    }

    static List<String> solve(int[] input, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (lower < input[0]) {
            result.add(makeRange(lower, input[0] - 1));
            lower = input[0] + 1;
        }

        for (int i = 1; i < input.length; i++) {
            if (input[i] < upper) {
                if (input[i] <= lower) {
                    lower++;
                    continue;
                }
                result.add(makeRange(lower, input[i] - 1));
                lower = input[i] + 1;
            } else {
                result.add(makeRange(lower, upper));
                return result;
            }
        }
        result.add(makeRange(lower, upper));

        return result;
    }

    static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : low + "->" + high;
    }
}
