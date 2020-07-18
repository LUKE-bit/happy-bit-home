import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
    }

    private static String reverse(String str) {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1;i >= 0;i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString();
    }
}
