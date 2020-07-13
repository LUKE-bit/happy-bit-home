import java.util.Scanner;

public class HEXConverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String str1 = str.substring(2);
            char[] arr = str1.toCharArray();
            int ten = 0;
            for (int i = 0;i < arr.length;i++) {
                int a = 0;
                if (arr[i] >= 'A' && arr[i] <= 'F') {
                    a = arr[i] - 'A' + 10;
                }else if (arr[i] >= 'a' && arr[i] <= 'f') {
                    a = arr[i] - 'a' + 10;
                }else {
                    a = arr[i] - '0';
                }
                ten += a * Math.pow(16,arr.length - 1 - i);
            }
            System.out.println(ten);
        }
    }
}
