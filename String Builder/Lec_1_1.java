public class Lec_1_1 {

    public static void main(String[] args) {

        //StringCom();
        StringBuilderCom();
    }

    // String builder is fast as compare

    public static void StringCom() {

        String s = "";

        for (int i = 0 ; i < 100000 ; i++){

            s = s + i;
        }

        System.out.println(s);
    }

    public static void StringBuilderCom() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 100000 ; i++){

            sb.append(i);
        }

        System.out.println(sb);
    }
}
