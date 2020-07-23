import java.util.Scanner;

public class CamelNameWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String[] arr = str.split("_");
            for (int i = 0;i < arr.length;i++){
                if (i != 0) {
                    char[] arr1 = arr[i].toCharArray();
                    for (int j = 0;j < arr1.length;j++){
                        if (j == 0) System.out.print(Character.toUpperCase(arr1[j]));
                        else System.out.print(arr1[j]);
                    }
                    continue;
                }
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
