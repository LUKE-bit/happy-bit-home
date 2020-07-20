import java.util.Scanner;

public class StringLockAndUnlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] arr1 = sc.nextLine().toCharArray();
            char[] arr2 = sc.nextLine().toCharArray();
            System.out.println(stringLock(arr1));
            System.out.println(stringUnlock(arr2));
        }
    }

    private static String stringUnlock(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c > 'a' && c <= 'z') {
                sb.append((char) (c - 1 - 32));
            } else if (c > 'A' && c <= 'Z') {
                sb.append((char) (c - 1 + 32));
            } else if (c == 'a') {
                sb.append('Z');
            } else if (c == 'A') {
                sb.append('z');
            } else if (c > '0' && c <= '9') {
                sb.append((char) (c - 1));
            } else if (c == '0') {
                sb.append('9');
            } else sb.append(c);
        }
        return sb.toString();
    }

    private static String stringLock(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c >= 'a' && c < 'z') {
                sb.append((char) (c + 1 - 32));
            } else if (c >= 'A' && c < 'Z') {
                sb.append((char) (c + 1 + 32));
            } else if (c == 'z') {
                sb.append('A');
            } else if (c == 'Z') {
                sb.append('a');
            } else if (c >= '0' && c < '9') {
                sb.append((char) (c + 1));
            } else if (c == '9') {
                sb.append('0');
            } else sb.append(c);
        }
        return sb.toString();
    }
}
