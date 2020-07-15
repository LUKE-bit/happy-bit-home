import java.util.Arrays;
import java.util.Scanner;

public class SticksProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < n;i++) {
            int type = sc.nextInt();
            int L = sc.nextInt();
            if (type == 1) {
                arr[i] = L;
            }else if (type == 2) {
                for (int j = i - 1;j >= 0;j--) {
                    if (arr[j] == L) {
                        arr[j] = 0;
                        break;
                    }
                }
            }
            if (ability(arr,i+1)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean ability(int[] arr, int n) {
        Arrays.sort(arr,0,n);
        int sum = 0;
        for (int i = 0;i < n-1;i++) {
            sum += arr[i];
        }
        return sum > arr[n - 1];
    }
}
