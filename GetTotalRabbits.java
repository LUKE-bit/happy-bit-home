import java.util.Scanner;

public class GetTotalRabbits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int ans = getTotalCount(n);
            System.out.println(ans);
        }
    }
    private static int getTotalCount(int n) {
        if (n <= 2) return 1;
        else return getTotalCount(n-1) + getTotalCount(n-2);
    }
}
