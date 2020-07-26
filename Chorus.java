import java.util.Scanner;

public class Chorus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1;i <= n;i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int d = sc.nextInt();
            long[][] f = new long[n+1][k+1];
            long[][] g = new long[n+1][k+1];
            for (int i = 1;i <= n;i++) {
                f[i][1] = arr[i];
                g[i][1] = arr[i];
            }
            for (int i = 2;i <= k;i++) {
                for (int j = i;j <= n;j++){
                    long max = Long.MIN_VALUE;
                    long min = Long.MAX_VALUE;
                    for (int left = Math.max(i - 1,j - d);left <= j - 1;left++) {
                        if (max < Math.max(f[left][i-1]*arr[j],g[left][i-1]*arr[j])) {
                            max = Math.max(f[left][i-1]*arr[j],g[left][i-1]*arr[j]);
                        }
                        if (min > Math.min(f[left][i-1]*arr[j],g[left][i-1]*arr[j])) {
                            min = Math.min(f[left][i-1]*arr[j],g[left][i-1]*arr[j]);
                        }
                    }
                    f[j][i] = max;
                    g[j][i] = min;
                }
            }
            long result = Long.MIN_VALUE;
            for (int i = k;i <=n;i++) {
                if (result < f[i][k]) {
                    result = f[i][k];
                }
            }
            System.out.println(result);
        }
    }
}
