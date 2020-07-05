import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = n;
            double a = 1.0;
            while (m!=0) {
                a *= m;
                m--;
            }
            double b = mixSort(n);
            double ret = b * 100 / a;
            System.out.println(String.format("%.2f",ret) + '%');
        }
    }

    private static double mixSort(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        else return (n-1) * (mixSort(n-1) + mixSort(n-2));
    }
}
