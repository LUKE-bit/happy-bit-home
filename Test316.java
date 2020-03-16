import java.util.Arrays;
public class Test0316 {

    public static void set(int[]arr){
        for(int i =0;i<arr.length;i++){
            arr[i] = i+1;
        }
    }
    public static void main4(String[] args) {
        int []arr = new int[100];
        set(arr);
    }
    public static void print(int[]arr){
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main3(String[] args) {
        int[]arr = {1,2,3,4};
        print(arr);
    }
    public static void transform(int[]arr){
        for(int i =0; i<arr.length;i++){
            arr[i] = arr[i]*2;
        }
    }
    public static void main2(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static double average(int[]arr){
        double sum = 0;
        for(int i =0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        return sum;
    }
    public static void main1(String[] args) {
        int[]arr = {1,2,3,4};
        double ret = average(arr);
        System.out.println(ret);
    }
}
