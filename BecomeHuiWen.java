import java.util.Scanner;

public class BecomeHuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            int j = arr.length - 1;
            int flg = 0;
            boolean flag = false;
            for (int i = 0;i < arr.length / 2;i++) {
                if (flg < 1 && arr[i] != arr[j]) {
                    if (j!=arr.length-1) {
                        j--;
                        flg++;
                    }
                    else flg++;
                }else if (flg <= 1 && arr[i] == arr[j]){
                    j--;
                    flag = true;
                }else if (flg <= 1 && arr[i] != arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
