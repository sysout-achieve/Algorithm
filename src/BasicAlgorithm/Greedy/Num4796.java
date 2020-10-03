package BasicAlgorithm.Greedy;

import java.util.Scanner;

public class Num4796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            i++;
            int seriesDays = scanner.nextInt();
            int operationDays = scanner.nextInt();
            int vacationDays = scanner.nextInt();
            if (seriesDays == 0 && operationDays == 0 && vacationDays == 0) return;
            int res1 = (vacationDays / operationDays) * seriesDays;
            int res2 = Math.min(seriesDays, (vacationDays % operationDays));
            int result = res1 + res2;
            System.out.println("Case " + i + ": " + result);
        }
    }
}
