import java.util.Scanner;

public class LevelUpYi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] monster = new int[n];
            for (int i = 0;i < n;i++) {
                monster[i] = sc.nextInt();
            }
            for (int i = 0;i < n;i++) {
                if (monster[i] <= a) {
                    a+=monster[i];
                }else {
                    a = a + maxDivisor(a,monster[i]);
                }
            }
            System.out.println(a);
        }
    }

    private static int maxDivisor(int a, int b) {
        if (a < b) {
            int k = a;
            a = b;
            b = k;
        }
        return a%b==0?b:maxDivisor(b,a%b);
    }
}
