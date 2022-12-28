

/*

Jo primitive ko non-primitive main convert kar de usse wrapper class bolte hain

---> Har ek primitive datatype ke corresponding non-primitive data type exists karta hain.

---> Class kaa naam hamesa se capital main suru hoga java main.

-------------------------------
Primitive   |  Non-Primitive or Wrapper Class
Datatype    |  Datatype
------------------------------
Byte        : Byte
short       : Short
int         : Integer
long        : Long
double      : Double
float       : Float
char        : Character
bool        : Boolean

----------------------------

Primitive (jo class nhi hain java main) and Non-primitive (jo class hain java main)
These 8 non-primitive data types are the wrapper class in java.

 */



public class Lec1 {

    public static void main(String[] args) {

         Integer a = 100; // Stores in the heap memory
         int a1 = 10; // Stores in the stack memory

         // Both will print the same data but memory heirarchy of both will be different.
        System.out.println(a + " " + a1);


       // Jab bhi class waala cheez atta hain toh uska memory location heap main hee hoga.



        /*

        Integer a = 100; // Stores in the heap memory
        int a1 = 10; // Stores in the stack memory



                          Stack Memory |     Heap Memory
                        ---------------|-------------------
                                       |
                                       |     100
                                       |    ------ at 1k address
                                       |
                       ----------------|
                           a = 1k      |
      ------>              a1 = 10     |
     Main Method                       |
     in stack


            But, sout(a) ---> karne se content print hoga address nhi jaise kii string main hota hain.
                 sout(a1) prints 10

         */

        // Non-Primitive / Class
        Short s1 = 78;
        Byte b1 = 19;

        System.out.println(s1 + " " + b1);

        Integer ii = 200;
        int i = 30;

        // Auto-boxing : Pritive ke upar wrap laga diya Non-primitive
        // Jab primitive ko non-primitive main convert karengye  toh auto-boxing khelaayega
        // Jab ek primitive ko uske corresponding wrapper class main rakhte hain toh woh Autoboxing khelaata hain.

        // int ------> Integr (Autoboxing)

        ii = i;// Pritive ko non-pritive main assign kar rahe hain.

        /*
        Autoboxing is the automatic convertion that the Java compiler makes btw the primitive types and their corresponding object wrapper classes.
         */

        System.out.println(i + " " + ii);

        int b = -5;
        Integer b2 = 90000;

        // Integer -----> int (Unboxing)

        b = b2; // Non-primitive ko primitive main change kar rahe hain toh : Unboxing

        System.out.println(b + " " + b2);

      // ----------------------------- Important--------------------------------------------

        Integer c1 = 10;
        Integer c2 = 10;

        // If we are comparing two non-primitive data then it will compare their address
        // For comparing their data we use ===

        // Integer class ke andarr ek integer catche hota hain.
        // Integer , Long , Short or Byte ke andarr ek catche hota hain.
        // aur in saare catche ke andarr bola jaata hain kii agar aapki value
        // -128 to 127 ke beech main hain toh ham duplicate value create nhi karengye ham ussi ke address ko point kara dengye.
        // Agar apka value 127 se bada hoga yaa fir -128 se chotta hoga toh values different locations par jaayengyi.

        // Since, c1 and c2 values are btw -128 to 127 i.e they will store at the same address and hence
        // after comparing address they  will give true.
        // i.e no duplicate will be created


        System.out.println(c1 == c2);

        Integer c3 = 178;
        Integer c4 = 178;



        // 178 and 178 will exceed 127 so, we have to give c4 and c3 a different address
        // i.e after comparing we will get false.
        // i.e duplicate will be created.
        // Let's say c3 created at 2k
        // Let's say c4 created at 4k
        System.out.println(c3 == c4);

        // --------------------------------------------------------------------------------------------------------------

        Integer x1 = 111;
        Integer x2 = 111;

        // It will print true as both the values are btw -128 to 127 so, they will be assign the same address
        // and hence after comparing they will give true.

        // We do this just to preserve the memory
        System.out.println(x1 == x2);

        Byte x3 = 12;
        Byte x4 = 12;

        System.out.println(x3 == x4);

        /*

        Integer    |
        Long       |
        Short      |-------- If values are duplicate and in the range -128 to 127 then those values will be assigned a same address.
        Byte       |

        Note : Agar iss range ke bahaar gaya toh duplicate create hoga.
               If both the values are in btw -128 to 127 then no duplicate will be created.

         */


        Long l1 = 123l;
        Long l2 = 123l;

        // It means range will be same for Integer , Long , Short and Byte.
        System.out.println(l1 == l2);


        // 127 and -128 is also included in that range.

        Long l3 = 127l;
        Long l4 = 127l;

        System.out.println(l3 == l4);

        Long l5 = -128l;
        Long l6 = -128l;

        System.out.println(l5 == l6);



    }
}
