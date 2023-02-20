package linklist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode first = new ListNode(-1, head);
        //创建一个虚拟头结点方便对首元结点进行处理
        ListNode pre = first;
        while (temp != null) {
            if (temp.val == val) {//删除结点
                pre.next = temp.next;
            } else {
                pre = temp;
            }
            temp = temp.next;
        }
        return first.next;

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}