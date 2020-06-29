import java.util.Scanner;

public class TheHighestPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] students = new int[N + 1];
            for (int i = 1;i <= N;i++) {
                students[i] = sc.nextInt();
            }
            for (int i = 1; i <= M;i++) {
                String c = sc.next();
                if ('Q' == c.charAt(0)) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int max = 0;
                    int x = Math.min(a,b);
                    int y = Math.max(a,b);
                    for (int j = x;j <= y;j++) {
                        if (students[j] > max) {
                            max = students[j];
                        }
                    }
                    System.out.println(max);
                }
                if ('U' == c.charAt(0)) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    students[a] = b;
                }
            }
        }
    }
}
