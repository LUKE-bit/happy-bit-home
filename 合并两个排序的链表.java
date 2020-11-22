/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode first = list1;
        ListNode last = list2;
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        while(first != null && last != null) {
            if(first.val <= last.val) {
                cur.next = first;
                first = first.next;
            }else{
                cur.next = last;
                last = last.next;
            }
            cur = cur.next;
        }
        if(first!=null){
            cur.next = first;
        }
        if(last!=null) {
            cur.next = last;
        }
        return ans.next;
    }
}
