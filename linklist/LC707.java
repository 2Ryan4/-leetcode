package linklist;

public class LC707 {
}
class MyLinkedList {
    public Node head;//虚拟头结点
    public int size;//元素个数

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        Node pre = head;//要插入位置的前一个结点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node newNode = new Node(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node pre = head;//要删除结点的前驱结点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}
class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {

    }
}
