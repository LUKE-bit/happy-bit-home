import java.util.Scanner;

public class LongestNumStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char[] arr = str.toCharArray();
            int j = 0;
            int len = 0;
            int k = 0;
            int max = 0;
            for (int i = 0;i < arr.length;i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    len++;
                    if (i + 1 == arr.length) {
                        if (len > max) {
                            max = len;
                            k = i;
                        }
                        break;
                    }
                    if (arr[i + 1] < '0' || arr[i + 1] > '9') {
                        if (len > max) {
                            max = len;
                            k = i;
                        }
                        len = 0;
                    }
                }
            }
            k = k - max + 1;
            for (int i = k;i < k + max;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
