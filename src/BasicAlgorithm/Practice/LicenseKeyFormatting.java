package BasicAlgorithm.Practice;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String input = "8F3Z-2e-9-w-sWer";
//        String input = "8-5g-3-J";

        int k = 4;
        System.out.println("res :"+solve(input, k));
    }
    public static String solve(String input, int k){
        StringBuilder sb = new StringBuilder(input.replace("-", "").toUpperCase());
        int leng = sb.length();
        for (int i = k; i < leng; i = i+k) {
            sb.insert(leng-i, "-");
        }
        return sb.toString();
    }
}
