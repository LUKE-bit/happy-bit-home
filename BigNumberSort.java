import java.math.BigInteger;
import java.util.*;
public class BigNumberSort  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            BigInteger[] a = new BigInteger[n];
            for (int i = 0;i < n;i++) {
                a[i] = sc.nextBigInteger();
            }
            Arrays.sort(a);
            for (int i = 0;i < n;i++) {
                System.out.println(a[i]);
            }

        }
    }
}
