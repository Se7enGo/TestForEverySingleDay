package day0612;

public class MainTest {

    // Definition for singly-linked list.

    public static void plus(ListNode result) {
        if (result.next != null) {
            if (result.val >= 10) {
                result.val = result.val - 10;
                ListNode next = result.next;
                next.val += 1;
                plus(next);
            } else {
                plus(result.next);
            }

        } else {
            if (result.val >= 10) {
                result.val = result.val - 10;
                result.next = new ListNode(1);
            }
        }
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);
//        ListNode l13 = new ListNode(2);

        l11.next = l12;
//        l12.next = l13;
        ListNode l21 = new ListNode(0);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(5);

//        l21.next = l22;
//        l22.next = l23;

        Solution so = new Solution();
        ListNode l31 = so.addTwoNumbers(l11,l21);

        plus(l31);
        ListNode temp = l31;
        while(temp.next!= null){
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        boolean bn = true;

        ListNode result = new ListNode(0);
        ListNode reTemp = result;
        do {

            if ( l1Temp.next== null ) {
                l1Temp.next = new ListNode(0);
                bn = false;
            }
            if(  l2Temp.next  == null){
                l2Temp.next = new ListNode(0);
                bn = false;
            }
            reTemp.val = l1Temp.val + l2Temp.val;
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
            reTemp.next = new ListNode(0);
            reTemp = reTemp.next;
        }while(bn);
        return result;
    }

}
