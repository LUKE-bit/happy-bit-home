import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long n = sc.nextLong();
            long m = n * n;
            int sum1 = 0;
            int sum2 = 0;
            while (n!=0) {
                sum1 += n%10;
                n /= 10;
            }
            while (m!=0) {
                sum2 += m%10;
                m /= 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}
