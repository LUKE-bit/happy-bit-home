import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchBrotherWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n =sc.nextInt();
            String[] arr = new String[n];
            String[] arr1 = new String[n];
            for (int i = 0;i < n;i++) {
                arr[i] = sc.next();
            }
            String str = sc.next();
            int k = 0;
            for (String s : arr) {
                if (isBrotherWord(s, str)) {
                    arr1[k] = s;
                    k++;
                }
            }
            for (int i = 0;i < k;i++) {
                int q = 0;
                for (int j = 0;j < k - 1 - i;j++) {
                    if (arr1[j].charAt(q) > arr1[j+1].charAt(q)) {
                        String temp = arr1[j];
                        arr1[j] = arr1[j+1];
                        arr1[j+1] = temp;
                        q = 0;
                    }else if (arr1[j].equals(arr1[j + 1])) {
                        q++;
                        j--;
                        if (q == arr1[j].length()) {
                            j++;
                            q = 0;
                        }else if (q == arr1[j+1].length()){
                            String temp = arr1[j];
                            arr1[j] = arr1[j+1];
                            arr1[j+1] = temp;
                            q = 0;
                        }
                    }
                }
            }
            int f = sc.nextInt();
            System.out.print(k + " ");
            if (k >= f)
                System.out.println(arr1[f - 1]);
        }
    }
    public static boolean isBrotherWord(String str,String Brother) {
        Map<Character,Integer> map = new HashMap<>();
        char[] arr1 = str.toCharArray();
        char[] arr2 = Brother.toCharArray();
        int flg = 0;
        for (char c : arr2) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
        }
        if (!str.equals(Brother) && str.length() == Brother.length()) {
            for (char c : arr1) {
                if (map.containsKey(c)) {
                    flg = 1;
                } else {
                    flg = 0;
                    break;
                }
            }
        }
        return flg == 1;
    }
}
