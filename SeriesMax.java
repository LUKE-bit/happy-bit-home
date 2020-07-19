import java.util.Scanner;

public class SeriesMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0;i < n;i++) {
                num[i] = sc.nextInt();
            }
            System.out.println(max(num,n));
        }
    }

    private static int max(int[] arr, int len) {
        if (arr == null || len <= 0) return -1;
        int sum = 0;
        int max = 0;
        for (int i = 0;i < len;i++) {
            if (sum <= 0) sum = arr[i];
            else sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
