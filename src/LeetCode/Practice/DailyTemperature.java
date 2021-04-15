package LeetCode.Practice;


import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solve(input);
        for (int i : result){
            System.out.print(i+" ");
        }
    }

    //DayTemp 클래스
    // for() 해당날짜의 기온확인 -> while (스택의 기온이 더 높은 기온 위에 해당하는 날짜기온 비교)

    private static int[] solve(int[] input) {
        Stack<DayTemp> stack = new Stack<>();
        int[] result = new int[input.length];
        stack.push(new DayTemp(input[0], 0));
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            while (!stack.isEmpty() && stack.peek().getTemperature() <= temp) {
                DayTemp dayTemp = stack.pop();
                result[dayTemp.position] = i - dayTemp.position;
            }
            stack.push(new DayTemp(temp, i));
        }
        return result;
    }

    static class DayTemp {
        int temperature;
        int position;

        public DayTemp(int temperature, int position) {
            this.temperature = temperature;
            this.position = position;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

}