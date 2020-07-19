import java.util.Scanner;

public class ArrayChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int x = 0,y = 0;
            String[] arr = str.split(";");
            for (String string:arr) {
                if (string.charAt(0) == 'W' && string.substring(1).matches("[0,9]{1,2}")) {
                    y += Integer.parseInt(string.substring(1,3));
                }
                if (string.charAt(0) == 'A' && string.substring(1).matches("[0,9]{1,2}")) {
                    x -= Integer.parseInt(string.substring(1,3));
                }
                if (string.charAt(0) == 'S' && string.substring(1).matches("[0,9]{1,2}")) {
                    y -= Integer.parseInt(string.substring(1,3));
                }
                if (string.charAt(0) == 'D' && string.substring(1).matches("[0,9]{1,2}")) {
                    x += Integer.parseInt(string.substring(1,3));
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
