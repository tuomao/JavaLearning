package leecode.ReverseList;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode temp = head;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }

        head=solution.ReverseList(head);
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        ListNode newHead=head;

        if(head!=null) {
            ListNode curNode = head.next;
            ListNode preNode=head;
            head.next=null;
            while (curNode != null) {
                ListNode temp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                newHead = curNode;
                curNode = temp;
            }
            head = newHead;
        }

        return newHead;
    }

    public int getListSize(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
