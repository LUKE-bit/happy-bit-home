import java.util.Arrays;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        int k = array[array.length / 2];
        for (int value : array) {
            if (value == k) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return k;
        }else return 0;
    }
}
