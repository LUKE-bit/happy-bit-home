import java.util.Scanner;

public class IPConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ip = sc.next();
            Long ip10 = sc.nextLong();
            String[] a = ip.split("\\.");
            long sum = 0;
            for (int i = 0;i < a.length;i++) {
                int c = Integer.parseInt(a[i]);
                int j = 0;
                int[] b = new int[8];
                while (c!=0) {
                    b[7-j] = c % 2;
                    sum += b[7-j] * Math.pow(2,(8 * (3 - i)) + j );
                    c /= 2;
                    j++;
                }
            }
            System.out.println(sum);
            long[] d = new long[4];
            long[] e = new long[8];
            for (int i = 3;i >= 0;i--) {
                int j = 0;
                long total = 0;
                while (ip10!=0) {
                    e[7-j] = ip10 % 2;
                    total += e[7-j] * Math.pow(2,j);
                    ip10 /= 2;
                    j++;
                    if (j==8) break;
                }
                d[i] = total;
            }
            for (int i = 0;i < 3;i++) {
                System.out.print(d[i] + ".");
            }
            System.out.println(d[3]);
        }
    }
}
