package BasicAlgorithm.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num2212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int censor = scanner.nextInt();
        int cast = scanner.nextInt();
        ArrayList<Integer> castline = new ArrayList<>();
        int result =0;
        ArrayList<Integer> censorList = new ArrayList<>();
        for (int i = 0; i < censor; i++) {
            int censorNum = scanner.nextInt();
            censorList.add(censorNum);
        }

        if (censor <= cast) {
            System.out.println(0);
            return;
        }
        Collections.sort(censorList);

        for (int i=1; i<censorList.size() ; i++){
            castline.add(censorList.get(i)- censorList.get(i-1));
        }

        Collections.sort(castline);

        for (int j=0; j<castline.size()-(cast-1); j++){
            result+=castline.get(j);
        }
        System.out.println(result);
    }
}
