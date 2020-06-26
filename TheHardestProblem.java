import java.util.Scanner;

public class TheHardestProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            char[] s = transtation(arr);
            for (int i = 0; i < s.length;i++) {
                System.out.print(s[i]);
            }
            System.out.println();
        }
    }

    private static char[] transtation(char[] arr) {
        char[]b = new char[arr.length];
        for (int i = 0;i < arr.length;i++) {
            if (arr[i]!=' ') {
                if (arr[i]=='A') b[i] = 'V';
                else if (arr[i]=='B') b[i] = 'W';
                else if (arr[i]=='C') b[i] = 'X';
                else if (arr[i]=='D') b[i] = 'Y';
                else if (arr[i]=='E') b[i] = 'Z';
                else b[i] = (char)(arr[i] - 5);
            }else b[i] = ' ';
        }
        return b;
    }
}
