package LeetCode.Medium;
import java.util.regex.Pattern;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {
        String tmpStr = s.replace(" ", "");
        StringBuilder sb= new StringBuilder();

        for (char c : tmpStr.toCharArray()){
            if (Pattern.matches("-", String.valueOf(c))&& sb.toString().equals("")) sb.append(c);
            if (Pattern.matches("(^[0-9]*$)", String.valueOf(c))) sb.append(c);
        }

        return Integer.parseInt(sb.toString());
    }
}
