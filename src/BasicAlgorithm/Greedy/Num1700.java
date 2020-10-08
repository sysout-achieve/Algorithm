package BasicAlgorithm.Greedy;

/*
test
3 14
1 4 3 2 5 4 3 2 5 3 4 2 3 4

1 4 3
2 4 3
5 4 3
5 2 3
4 2 3

1 4 3
1 2 3
1 2 5
1 4 5
*/
import java.util.Scanner;

public class Num1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int plugCnt = sc.nextInt();
        int toolCnt = sc.nextInt();

        int[] toolList = new int[toolCnt];
        int[] plugs = new int[plugCnt];
        for (int i = 0; i < toolCnt; i++) {
            toolList[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < toolCnt; i++) {
            for (int j = 0; j < plugCnt; j++) {
                if (plugs[j] == 0) {
                    plugs[j] = toolList[i];
                    break;
                } else {
                    if (plugs[j] == toolList[i]) {
                        break;
                    }
                    if (j != plugCnt - 1) continue;

                    int chage = 0, val = -1;
                    for (int k = 0; k < plugCnt; k++) {
                        int term = 0;
                        for (int l = i + 1; l < toolCnt && toolList[l] != plugs[k]; l++) {
                            term++;
                        }
                        if (term > val) {
                            val = term;
                            chage = k;
                        }
                    }
                    plugs[chage] = toolList[i];
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}