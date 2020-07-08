import java.util.*;

public class SimpleWrongRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String ,Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String filePath = sc.next();
            int row = sc.nextInt();
            String fileName = filePath.substring(filePath.lastIndexOf('\\') + 1);
            String key = fileName + " " + row;
            if (map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            }else {
                map.put(key,1);
            }
        }
        List<Map.Entry<String ,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String ,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        int m = 0;
        for (Map.Entry<String ,Integer>mapping : list) {
            if (m >= 8) break;
            String[] a = mapping.getKey().split(" ");
            String fileName = a[0];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String n = a[1];
            int count = mapping.getValue();
            System.out.printf("%s %s %d%n",fileName,n,count);
        }
    }
}
