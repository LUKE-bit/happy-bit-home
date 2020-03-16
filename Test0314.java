import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Arrays;
import java.util.Scanner;

public class Test0314 {
    //自己写的toString函数
    public static String mytoString(int[]arr){
        String ret = "[";
        for(int i = 0;i<arr.length;i++)
        {
            ret+=arr[i];
            if(i!=arr.length-1){
                ret+=",";
            }
        }
        ret+="]";
        return ret;
    }

    public static void main2(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(mytoString(arr));
    }
    public static int[] fun(int[] arr){
        int[]array = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            array[i] = arr[i];
        }
        return array;
    }
    public static int[]  func(){
        int[] arrey = {1,2,3};
        return arrey;
    }
    public static void swap(int[] arr){
        int temp = 0;
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[]arr1 = new int[3];
//        int[]arr2 = {1,2,3};
//        int[]arr3 = new int[]{1,2,3};
//        int[] copyArr1 = fun(arr2);
//        System.out.println(Arrays.toString(copyArr1));
//        for(int i = 0;i< arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }
//        for (int i:arr2){
//            System.out.print(i+" ");
//        }
//        System.out.println(Arrays.toString(arr3));
//        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(array2.length);
//        System.out.println(array2[0]);
//        array2[0] = 888;
//        System.out.println(array2[0]);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int[] arr = new int[]{a,b};
//        swap(arr);
//        System.out.println(arr[0]+ " " +arr[1])
//        int[]ret = func();
//        System.out.println(Arrays.toString(ret));

    }
}
