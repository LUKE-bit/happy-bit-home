class Node1{
    public int data;
    public Node1 next;
    public Node1(int data){
        this.data = data;
        this.next = null;
    }
}
public class MyLindList2 {
    public Node1 head;
    public MyLindList2(){this.head = null;}
    public void addOrder(int data) {
        Node1 node = new Node1(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        if(data<this.head.data) {//如果小于头，那直接插在头前就好了
            node.next = this.head;
            this.head = node;
            return;
        }
        else {
            Node1 prev = this.head;
            while(prev.next.data<=data) {//找前驱，同样是为了确定插入的位置。
                prev = prev.next;
                if(prev.next==null) {//要添加的元素是最大的，直接插在最后即可。
                    prev.next = node;
                    return;
                }
            }
            Node1 p = this.head;
            while(p.data<data) {//找到比传过来的data大的就能确定插入的位置了。
                p = p.next;
            }
            node.next = p;
            prev.next = node;
        }
    }
    public void display(Node1 head) {
        Node1 p = head;
        while(p!=null) {
            System.out.println(p.data);
            p = p.next;
        }
    }
    public void change(int pos,int key) {
        Node1 p = this.head;
        if (pos==1) {
            p.data = key;
            return;
        }
        pos = pos-1;
        while (true) {
            p = p.next;
            pos = pos-1;
            if(pos == 0) {
                p.data = key;
                return;
            }
        }
    }
    public Node1 reverse(Node1 head) {
        if(head==null||head.next==null) {
            return head;
        }
        Node1 temp = head.next;
        Node1 newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public Node1 getHead() {
        return this.head;
    }
    public Node1 reverseList() {
        Node1 cur = this.head;
        Node1 newHead = null;
        Node1 prev = null;
        while(cur!=null) {
            Node1 curNext = cur.next;
            if (curNext==null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public Node1 findKthToTtil(int k) {
        if(k<=0 || this.head==null) {
            return null;
        }
        Node1 fast = this.head;
        Node1 slow = this.head;
        for (int i = 0;i<k-1;i++) {//先让fast走k-1步
            if (fast.next!=null) {
                fast = fast.next;
            }else {
                System.out.println("没有该节点");
                return null;
            }

        }
        //再一起走
        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node1 partion(int x) {
        Node1 bs = null;
        Node1 be = null;
        Node1 as  = null;
        Node1 ae = null;
        Node1 cur = this.head;
        while (cur!=null) {
            if(cur.data<x) {
                if(bs==null) {
                    bs = cur;
                    be = bs;
                }
                else {
                    be.next = cur;
                    be = cur;
                }
            }else {
                if(as==null) {
                    as = cur;
                    ae = as;
                }
                else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        if(bs==null) {
            return as;
        }
        be.next = as;
        if(as.next!=null) {
            ae.next = null;
        }
        return bs;
    }
    public Node1 deleteDuplication() {
        Node1 node = new Node1(-1);
        Node1 tmp = node;
        Node1 cur = this.head;
        while(cur!=null) {
            if(cur.next!=null&&cur.data == cur.next.data) {
                while (cur.next!=null&&cur.data==cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    public boolean chkPalindrome() {
        Node1 fast = this.head;
        Node1 slow = this.head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node1 cur = slow.next;
        while(cur!=null) {
           Node1 curNext = cur.next;
           cur.next = slow;
           slow = cur;
           cur =curNext;
        }
        //slow指向最后一个节点
        while (slow!=this.head) {
            if(slow.data!=this.head.data) {
                return false;
            }
            if (this.head.next==slow) {//判断偶数
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }
}
