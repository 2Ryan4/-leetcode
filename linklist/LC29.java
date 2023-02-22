package linklist;

public class LC29 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode();//虚拟头结点，方便对首元结点进行处理
            dummyHead.next = head;
            ListNode fast = dummyHead;//用来帮助慢指针定位
            ListNode slow = dummyHead;//删除结点的前驱结点
            //想让fast移动n+1步，使双指针之间差n个节点
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            //双指针同时移动，直至fast为null，slow指向删除结点的前驱结点
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummyHead.next;


        }
    }
}
