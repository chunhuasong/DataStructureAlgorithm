package easy;

import org.junit.Test;

import java.util.ArrayList;

public class mergeTwoLists {
//递归
     public ListNode mergeTwoLists (ListNode l1, ListNode l2){
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                //递归
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

    //迭代
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){

        ListNode head = new ListNode();
        ListNode pre = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null){
            pre.next = l2;
        }
        else{
            pre.next = l1;
        }

        return head.next;

    }
        @Test
     public void test(){

         ListNode l1 = new ListNode(3);
         l1 = new ListNode(2,l1);
         l1 = new ListNode(1,l1);
            System.out.println(l1);
            ListNode l2 = new ListNode(4);
            l2 = new ListNode(2,l2);
            l2 = new ListNode(1,l2);

            ListNode merge = mergeTwoLists (l1, l2);

        }


}
class ListNode {


    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
