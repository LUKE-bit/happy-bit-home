import java.util.Scanner;
import java.util.Stack;

public class TheTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[] a = new int[11];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            Stack stack = new Stack();
            for (int i = 0;i < N;i++) {
                stack.push(a[i]);
            }
            int readyToIn = 0;
            int outAlready = 0;
            int readyToOut = 0;
            order(stack,readyToOut,readyToIn,outAlready);
        }
    }
    static int q;
    private static void order(Stack stack,int readyToOut,int readyToIn,int outAlready) {
        if (stack.empty()&&readyToIn==0) {
            System.out.println(outAlready);
            return;
        }
        order(stack,q =(int)stack.pop(),readyToIn,outAlready+1);
        order(stack,(int)stack.push(q),readyToIn-1,outAlready);
    }
}