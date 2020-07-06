import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] a = str.toCharArray();
            int[] c = new int[8];
            for (int value : a) {
                int b = value;
                int j = 0;
                int cnt = 0;
                while (b != 0) {
                    c[7 - j] = b % 2;
                    j++;
                    b /= 2;
                }
                for (int k = 0; k < 8; k++) {
                    if (c[k] == 1) cnt++;
                }
                if (cnt % 2 == 0) c[0] = 1;
                for (int q = 0; q < 8; q++) {
                    System.out.print(c[q]);
                }
                System.out.println();
                for (int p = 0;p < 8;p++) {
                    c[p] = 0;
                }
            }
        }
    }
}
