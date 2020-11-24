package BasicAlgorithm.Basic;

public class StringTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        StringBuffer str = new StringBuffer();
//        int i =0;
//        while (i<100000){
//            str = str.append("world");
//            System.out.print(Runtime.getRuntime().totalMemory()+"\n\n\n");
//            i++;
//        }


//        StringBuilder str = new StringBuilder();
//        int i =0;
//        while (i<100000){
//            str = str.append("world");
//            System.out.print(Runtime.getRuntime().totalMemory()+"\n\n\n");
//            i++;
//        }


        String str = "";
        int i = 0;
        while (i < 100000) {
            str = str + "world";
            System.out.print(Runtime.getRuntime().totalMemory() + "\n\n\n");
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (end - start) / 1000.0 + "sec");

    }
}
//StringBuffer -> 272629760,
//실행 시간 : 0.217sec

//StringBuilder -> 272629760
//실행 시간 : 0.219sec

//String -> 721420288
//실행 시간 : 4.393sec