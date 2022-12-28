public class Lec1 {

    public static void main(String[] args) {

        // String in java is immutable
        /*

        s = "hello"
        s = s + "bye"  -----> Isme puraana data kahi copy hoga fir hello add hoga i.e immutable nature.


        But string builder is mutable in nature and we have a class in java.


         */

        // String builder class in java which internally stores in the array.
        // It is formed in the heap
        // It is faster than String
        StringBuilder sb = new StringBuilder("Hello");

        // To get the size of the string builder.
        System.out.println(sb.length());

        // To get the capacity of the string builder.
        System.out.println(sb.capacity());


        /*

        Aur jab string builder main hello add karengye toh default capacity main woh string kaa size i.e 5 add ho jaayega.
        i.e String length = 16 + 5 = 21

         */

        // Imp :
        //capacity in string builder will be grown by : oldCapacity * 2 + 2

        // Appending the character in the string builder.
        sb.append('c');

        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.append("Helloc");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.append("HellocHelloc");
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        // Inserting String at a particular index
        sb.insert(1,"ll");
        System.out.println(sb);


        // Converting string builder to String
        String s = sb.toString();


        // Reversing the String builder : But No change in the original builder
        System.out.println(sb.reverse());


        // Getting character at a particular index in a string.
        System.out.println(sb.charAt(3));

        // Getting substring from the string
        System.out.println(sb.substring(1,3));


    }
}
