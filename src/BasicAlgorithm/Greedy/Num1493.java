package BasicAlgorithm.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Num1493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int boxLength = sc.nextInt();
        int boxWidth = sc.nextInt();
        int boxHeight = sc.nextInt();
        Cube box = new Cube(boxLength, boxWidth, boxHeight);

        int cubeType = sc.nextInt();
        ArrayList<Cube> cubeTypes = new ArrayList<>();
        for (int i = 0; i < cubeType; i++) {
            int size = sc.nextInt();
            int count = sc.nextInt();
            cubeTypes.add(new Cube(size, count));
        }

        cubeTypes.sort(Cube::compareTo);
        for (int i = 0; i < cubeType; i++) {
            result = result + box.enterCube(cubeTypes.get(i));
        }
        if (box.volume == 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }
}

class Cube implements Comparable<Cube> {
    int length;
    int width;
    int height;

    int cubeCount;
    int volume;

    public Cube(int n, int cubeCount) {
        int value = (int) Math.pow(2, n);
        this.length = value;
        this.width = value;
        this.height = value;
        this.cubeCount = cubeCount;
        this.volume = length * width * height;
    }

    public Cube(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }

    public boolean isEnter(Cube cube) {
        if (length < cube.length) return false;
        if (width < cube.width) return false;
        if (height < cube.height) return false;
        return true;
    }

    public int enterCube(Cube cube) {
        if (isEnter(cube) && volume != 0) {
            int enterCnt = Math.min(volume / cube.volume, cube.cubeCount);
            this.volume -= enterCnt * cube.volume;
            return enterCnt;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Cube o) {
        return o.volume - volume;
    }
}