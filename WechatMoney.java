public class WechatMoney {
    public static int getValue(int[] gifts, int n) {
        int[]num = new int[n];
        int flg = 0;
        int cnt = 1;
        int[]type = new int[n];
        type[0] = gifts[0];
        for (int i = 0;i < n;i++) {
           for (int j = i-1;j>=0;j--) {
               if (gifts[i]!=gifts[j]) {
                   flg = 1;
               }else{
                   flg = 0;
                   break;
               }
           }
           if (flg==1) {
               type[i] = gifts[i];
               cnt++;
           }
        }
        for (int i = 0;i < cnt;i++) {
            for (int j = 0;j < n;j++) {
                if (type[i]==gifts[j]) {
                    num[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0;i < cnt;i++) {
            if (num[i]>n/2){
                ans = gifts[i];
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]a = new int[]{3,2,3};
        int ret = getValue(a,3);
        System.out.println(ret);
    }
}
