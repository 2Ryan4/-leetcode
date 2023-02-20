package linklist;

public class LC206 {
    public ListNode1 reverseList(ListNode1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode1 cur = head;
        ListNode1 pre = null;//cur的前驱结点
        ListNode1 temp = null;//用于保存原来cur的后驱结点
        while(cur != null) {
            temp = cur.next;
            cur.next = pre;//指向前驱结点，反转
            //双指针移动
            pre = cur;
            cur = temp;
        }
        return pre;

    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

