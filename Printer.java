public class Printer {
    private int[] arrayPrint(int[][] arr,int n) {
        int[] target = new int[n*n];
        int q = 0;
        int i = 0;
        int j = n -1;
        for (j = n - 1;j >= 0;j--) {
            int a = i,b = j;
            while (a >=0 && a <= n-1 && b >=0 && b <= n-1) {
                target[q] = arr[a][b];
                q++;
                a++;
                b++;
            }
        }
        for (i = 1;i <= n - 1;i++) {
            int a = i,b = j + 1;
            while (a >= 0 && a <= n-1 && b >=0 && b <= n-1) {
                target[q] = arr[a][b];
                q++;
                a++;
                b++;
            }
        }
        return target;
    }
}
