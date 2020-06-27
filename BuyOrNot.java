import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
public class BuyOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            String b = sc.nextLine();
            char[]aa = a.toCharArray();
            char[]bb = b.toCharArray();
            Map<Character,Integer> owner = new HashMap<>();
            for (char c:aa) {
                if (owner.containsKey(c)) {
                    owner.put(c,owner.get(c) + 1);
                }else {
                    owner.put(c,1);
                }
            }
            Map<Character,Integer> buyer = new HashMap<>();
            for (char c : bb) {
                if (buyer.containsKey(c)) {
                    buyer.put(c,buyer.get(c) + 1);
                }else {
                    buyer.put(c,1);
                }
            }
            boolean flg = true;
            int lack = 0;
            for (Entry<Character,Integer> c : buyer.entrySet()) {
                char x = c.getKey();
                int y = c.getValue();
                if (owner.containsKey(x)&&owner.get(x) < y) {
                    flg = false;
                    lack += y - owner.get(x);
                }else if (!owner.containsKey(x)){
                    flg = false;
                    lack += y;
                }
            }
            if (flg) {
                System.out.println("Yes " + (a.length() - b.length()));
            }else {
                System.out.println("NO " + lack);
            }
    }
}
