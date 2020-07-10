import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Roshambo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Astatus = new int[3];
        int c = 0,j = 0,b = 0;
        int c1 = 0,j1 = 0,b1 = 0;
        for (int i = 0;i < n + 1;i++) {
            String[] a = sc.nextLine().split(" ");
            if (a[0].equals("C")) {
                if (a[1].equals("J")) {
                    Astatus[0]++;
                    c++;
                }
                else if (a[1].equals("C")) Astatus[1]++;
                else {
                    Astatus[2]++;
                    c1++;
                }
            }
            if (a[0].equals("J")) {
                if (a[1].equals("B")) {
                    Astatus[0]++;
                    j++;
                }
                else if (a[1].equals("J")) Astatus[1]++;
                else {
                    Astatus[2]++;
                    j1++;
                }
            }
            if (a[0].equals("B")) {
                if (a[1].equals("C")) {
                    Astatus[0]++;
                    b++;
                }
                else if (a[1].equals("B")) Astatus[1]++;
                else {
                    Astatus[2]++;
                    b1++;
                }
            }
        }
        int max = Math.max(c,Math.max(j,b));
        int min = Math.min(c1,Math.min(j1,b1));
        StringBuffer str = new StringBuffer("");
        StringBuffer str1 = new StringBuffer("");
        if (b1==min) {
            str1 = str1.append('B');
        }else if (c1==min) str1 = str1.append('C');
        else if (j1==min) str1 = str1.append('J');
        if (b==max) {
            str = str.append('B');
        }else if (c==max) str = str.append('C');
        else if (j==max) str = str.append('J');
        System.out.println(Astatus[0] + " " + Astatus[1] + " " + Astatus[2]);
        System.out.println(Astatus[2] + " " + Astatus[1] + " " + Astatus[0]);
        System.out.print(str + " " + str1);
    }
}
