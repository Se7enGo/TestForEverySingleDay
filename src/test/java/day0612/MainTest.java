package day0612;

public class MainTest {


    // Definition for singly-linked list.
      class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            boolean bn = true;
            while(bn){
                if((null == l1.next) && (null == l2.next)){
                    bn = false;
                }
                result.val = l1.val + l2.val;

            }


            return result;
        }

    }

    public static void plus(ListNode result){
        if(result.next != null){
            if(result.val >=10){
                result.val = result.val -10;
                ListNode next =  result.next;
                next.val += 1;
                plus(next);
            }else{
                plus(result.next);
            }

        }else{
            if(result.val >=10){
                result.val = result.val - 10;
                result.next = new ListNode(1);
            }
        }
    }

}
