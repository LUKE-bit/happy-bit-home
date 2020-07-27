import java.util.Scanner;

public class LeftRightMaxnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[]{2,7,3,1,1};
        System.out.println(findMaxGap(A,5));
    }
    public static int findMaxGap(int[] A, int n) {
        int c = 0;
        int Max = 0;
        int[] max = new int[n - 1];
        for (int k = 0;k <= n - 2;k++) {
            int max1 = 0;
            int max2 = 0;
            for (int i = k;i >= 0;i--) {
                if (A[i] > max1) {
                    max1 = A[i];
                }
            }
            for (int j = k + 1;j < n;j++) {
                if (A[j] > max2) {
                    max2 = A[j];
                }
            }
            max[c++] = Math.abs(max1 - max2);
        }
        for (int i = 0;i < n - 1;i++) {
            if (max[i] > Max) {
                Max = max[i];
            }
        }
        return Max;
    }
}
