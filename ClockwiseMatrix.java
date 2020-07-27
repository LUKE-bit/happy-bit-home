import java.util.Scanner;

public class ClockwiseMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[][]{{1,2},{3,4}};
        int[] clockwisePrint = clockwisePrint(mat,2,2);
        for (int i = 0;i < clockwisePrint.length;i++) {
            System.out.println(clockwisePrint[i]);
        }
    }
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] steps = new int[n * m];
        int[][] flg = new int[m + 1][n + 1];
        int startx = 0;
        int starty = 0;
        int i = 0;
        while (i  != n*m) {
            while ( startx < n && flg[starty][startx] != 1) {
                steps[i++] = mat[starty][startx];
                flg[starty][startx] = 1;
                if (startx != n - 1) {
                    startx++;
                }

            }
            starty++;
            while ( starty < m && flg[starty][startx] != 1) {
                steps[i++] = mat[starty][startx];
                flg[starty][startx] = 1;
                if (starty!=m-1) {
                    starty++;
                }

            }
            startx--;
            while (startx>=0 &&  flg[starty][startx] != 1) {
                steps[i++] = mat[starty][startx];
                flg[starty][startx] = 1;
                if (startx != 0) {
                    startx--;
                }

            }
            starty--;
            while ( starty >=0 && flg[starty][startx] != 1) {
                steps[i++] = mat[starty][startx];
                flg[starty][startx] = 1;
                if (starty != 0) {
                    starty--;
                }

            }
            startx++;
        }
       return steps;
    }
}
