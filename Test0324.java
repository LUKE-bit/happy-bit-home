public class Test0324 {
    public static void createCut(Node1 headA,Node1 headB) {
        headA.next = headB.next.next;
    }
    public static Node1 getIntersectionNode(Node1 headA,Node1 headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;

        Node1 pL = headA;
        Node1 pS = headB;

        while(pL!=null) {
            lenA++;
            pL = pL.next;
        }

        while (pS!=null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;

        int len = lenA - lenB;
        if (len<0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        //保证：篇指向长的单链表。len值是正数。
        while (len > 0) {
            pL = pL.next;
            len--;
        }
        while (pL!=pS) {
            pL = pL.next;
            pS = pS.next;
        }
        if(pL!=null&&pL==pS) {
            return pL;
        }
        return null;
    }
    public static void main(String[] args) {
        MyLindList2 myLindList2 = new MyLindList2();
        myLindList2.addOrder(12);
        myLindList2.addOrder(6);
        myLindList2.addOrder(9);
        myLindList2.addOrder(15);
//        Node1 re = myLindList2.partion(7);
//        myLindList2.display(re);

//        myLindList2.display(myLindList2.getHead());
//        System.out.println("//////////////");
//        myLindList2.change(3,2);
//        myLindList2.display(myLindList2.getHead());
//        System.out.println("//////////////");
        //Node1  newHead = myLindList2.reverse(myLindList2.getHead());
        //myLindList2.display(newHead);
        //System.out.println("//////////////");
        //Node1 ret = myLindList2.reverseList();
        //myLindList2.display(ret);
//        Node1 rett = myLindList2.findKthToTtil(2);
//        System.out.println(rett.data);
        MyLindList2 myLindList = new MyLindList2();
        myLindList.addOrder(122);
        myLindList.addOrder(6);
        myLindList.addOrder(7);
        myLindList.addOrder(5);
        createCut(myLindList.head,myLindList2.head);
        Node1 ret = getIntersectionNode(myLindList.head,myLindList2.head);
        System.out.println(ret.data);
    }
}
