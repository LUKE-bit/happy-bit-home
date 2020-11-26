import java.util.Scanner;

public class FindCommonSuffix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int bL = b.length()-1;
        int start = a.length();
        for (int i = a.length()-1;i>=0;i--) {
            if (a.charAt(i)== b.charAt(bL)) {
                start = i;
                bL--;
            }else {
                break;
            }
        }
        if(start < a.length()) {
            System.out.print("The common suffix is ");
            for (int i = start;i < a.length();i++) {
                System.out.print(a.charAt(i));
            }
            System.out.print(".");
        }else {
            System.out.println("No common suffix.");
        }
    }
}
