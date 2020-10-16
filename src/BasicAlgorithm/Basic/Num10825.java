package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        ArrayList<User2> userList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());
            int point3 = Integer.parseInt(st.nextToken());
            userList.add(new User2(point1, point2, point3, name));
        }
        Collections.sort(userList);

        for (int i = 0; i < cnt; i++) {
            bw.write(userList.get(i).getName());
        }

        bw.flush();
    }
}

class User2 implements Comparable<User2> {

    int point1;
    int point2;
    int point3;
    String name;

    public User2(int point1, int point2, int point3, String name) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.name = name;
    }

    public String getName() {
        return name+"\n";
    }

    @Override
    public int compareTo(User2 o) {
        if (point1 == o.point1) {
            if (point2 == o.point2) {
                if (point3 == o.point3) {
                    return name.compareTo(o.name);
                }
                return o.point3 - point3;
            }
            return point2 - o.point2;
        }
        return o.point1 - point1;
    }


}
