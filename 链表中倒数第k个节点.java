/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        int n = 0;
        ListNode fast = head,slow = head;
        for(int i = 0;i < k && fast!=null;i++) {
            fast = fast.next;
            n++;
        }
        if(k > n){
            return null;
        }
        while(fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
