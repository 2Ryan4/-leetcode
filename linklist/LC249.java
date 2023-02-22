package linklist;

import java.util.Stack;

public class LC249 {
    int pos = -1;
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;//每次移动两步
        ListNode slow = head;//每次移动一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {//相遇了
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                    pos++;
                }//环相遇节点和环入口的节点数与链表头结点和环入口的节点数相等
                return index1;
            }
        }
        return null;
    }
}
