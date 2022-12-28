package S_150;

public class Arrays {

    public static void main(String[] args) {

        int arr[] = null; // Memory not allocated
        System.out.println(arr);

//        Agr koi cheez class hain toh woh non-primitive data type hain
//        aur non-primitive datatype "Heap" main store hoga.
        int arr1[] = new int [5]; // Memory is allocated.

        System.out.println(arr1);
//        [I@7699a589 where [ denotes non-dimensional array , I denotes integer class and @7699a589 is the hash code.

        arr1[0] = 1;

        for(int i = 0; i < 5; i++){
            System.out.print(arr1[i] +  " ");
        }

        System.out.println();

//        Copying arr1 array
        int other[] = arr1;

        arr1[2] = 567;

// i.e changes in the arr1 also reflects to the other array also.

        for(int i = 0; i < 5; i++){
            System.out.print(other[i] +  " ");
        }

    }
}
