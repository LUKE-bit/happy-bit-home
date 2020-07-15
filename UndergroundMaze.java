import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UndergroundMaze {
    static int n,m;
    static int[][] arr;
    static int maxRemainEnergy = 0;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int P = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n;i++) {
            for (int j = 0;j < m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        runMap(0,0,P);
        if (!flag) System.out.println("Can not escape!");
        else System.out.println(path);
    }

    private static void runMap(int x, int y, int energy) {
        if (x < 0 || x >= n || y < 0 || y >= m || energy < 0 || arr[x][y] == 0) return;
        else {
            linkedList.offer("[" + x + "," + y +  "]");
            arr[x][y] = 0;
            if (x == 0 && y== m - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    updataPath();
                }
                arr[x][y] = 1;
                linkedList.removeLast();
                flag = true;
                return;
            }
            runMap(x,y + 1,energy - 1);
            runMap(x + 1,y,energy - 3);
            runMap(x - 1,y,energy);
            runMap(x,y -1,energy - 1);
            arr[x][y] = 1;
            linkedList.removeLast();
        }
    }

    private static void updataPath() {
        StringBuilder sb = new StringBuilder();
        for (String s : linkedList) {
            sb.append(s + ",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        path = sb.toString();
    }
}
