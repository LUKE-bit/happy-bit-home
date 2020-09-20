import java.util.Scanner;

public class MinestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (i>0 && j >0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
                else if (i==0 && j==0) {
                    dp[i][j] = arr[i][j];
                }
                else if (i==0) {
                    dp[i][j] = arr[i][j] + dp[i][j-1];
                }
                else  {
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
