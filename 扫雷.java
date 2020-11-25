import java.util.Scanner;

public class RemoveMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String ss = sc.nextLine();
        String[][] arr = new String[n][m];
        for(int i = 0;i < n;i++) {
            String str = sc.nextLine();
            for(int j = 0;j < m;j++) {
                if(j==m-1) {
                    arr[i][j] = str.substring(j);
                    break;
                }
                arr[i][j] = str.substring(j,j+1);
            }
        }
        for(int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                if("?".equals(arr[i][j])) {
                    arr[i][j] = nummberOfMine(arr,i,j);
                }
            }
        }
        for(int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static String  nummberOfMine(String[][] arr,int i,int j) {
        int num = 0;
        if(i-1>=0 && j-1>=0 && "*".equals(arr[i - 1][j - 1])) num++;
        if (i-1>=0 && "*".equals(arr[i - 1][j])) num++;
        if (i-1>=0 && j+1<arr[0].length && "*".equals(arr[i - 1][j + 1])) num++;
        if(j-1>=0 && "*".equals(arr[i][j - 1])) num++;
        if(j+1<arr[0].length && "*".equals(arr[i][j + 1])) num++;
        if(i+1<arr.length && j-1 >=0 && "*".equals(arr[i + 1][j - 1])) num++;
        if(i+1<arr.length && "*".equals(arr[i + 1][j])) num++;
        if(i+1<arr.length && j+1<arr[0].length && "*".equals(arr[i + 1][j + 1])) num++;
        return String.valueOf(num);
    }
}
