import java.util.Scanner;

public class Not2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] arr = str.split(" ");
        int []a = new int[arr.length];
        int ret = 0;
        for (int i = 0;i<arr.length;i++) {
            a[i] = Integer.valueOf(arr[i]);
        }
        int [][]b = new int[1200][1200];
        for (int i = 50;i < a[0] + 50;i++) {
            for (int j = 50;j < 50 + a[1];j++) {
                if (b[i][j] == 0&&b[i-2][j]==0&&b[i+2][j]==0&&b[i][j-2]==0&&b[i][j+2]==0) {
                    b[i][j] = 1;
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}
