package BasicAlgorithm.Basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        ArrayList<User> userList = new ArrayList<>();
        for (int i =0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            userList.add(new User(age, name));
        }
        Collections.sort(userList);

        for (int i=0; i<cnt; i++){
            bw.write(userList.get(i).getInfo());
        }

        bw.flush();
    }
}

class User implements Comparable<User>{
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return age-o.age;
    }

    public String getInfo(){
        return age+" "+name+"\n";
    }
}
