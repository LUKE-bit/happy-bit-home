import java.util.Scanner;

public class CountOfCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int[] count = new int[26];
            for (int i = 0;i < str.length();i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    count[c-'A']++;
                }
            }
            for (int i = 0;i < 26;i++) {
                System.out.printf("%c:%d%n",('A' + i),count[i]);
            }
        }
    }
}
