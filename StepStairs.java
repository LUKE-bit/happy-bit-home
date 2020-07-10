import java.util.Scanner;

public class StepStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  count = countWays(n);
        System.out.println(count);
    }

    private static int countWays(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int a = 1, b = 2, c = 4;
        int temp = 0;
        for (int i = 4; i <= n; i++) {
            temp = (a % 1000000007 + (b + c) % 1000000007)%1000000007;
            a = b ;
            b = c ;
            c = temp;
        }
        return temp % 1000000007;
    }
//        public static int countWays(int n) {
//            int array[] =new int[n];
//            array[0] =1;
//            array[1] =2;
//            array[2] =4;
//            for(int i=3;i<n;i++){
//                array[i]=((array[i-1]+array[i-2])%1000000007+array[i-3]%1000000007)%1000000007;
//            }
//            return array[n-1];
//        }
}

