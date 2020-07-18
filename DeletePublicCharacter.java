import java.util.Scanner;

public class DeletePublicCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int flg = 0;
            char[] arr1 = sc.nextLine().toCharArray();
            char[] arr2 = sc.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : arr1) {
                for (char value : arr2) {
                    if (c != value) {
                        flg = 1;
                    } else {
                        flg = 0;
                        break;
                    }
                }
                if (flg == 1) {
                    sb.append(c);
                }
            }
            String str = sb.toString();
            System.out.println(str);
        }
    }
}
