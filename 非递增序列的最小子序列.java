import java.util.Comparator;
import java.util.Arrays;
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int ans = 0;
        int flag = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length - 1;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if(nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for(int i = 0;i < nums.length;i++) {
            flag = i;
            ans += nums[i];
            int ret = 0;
            for(int j = i + 1;j < nums.length;j++) {
                ret+=nums[j];
            }
            if(ans > ret) {
                break;
            }
        }
        for(int k = 0;k <= flag;k++) {
            list.add(nums[k]);
        }
        return list;
    }
}
