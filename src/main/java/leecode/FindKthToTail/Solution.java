package leecode.FindKthToTail;

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
        ListNode node = solution.FindKthToTail(head, 3);
        System.out.println(node.val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {

        int listSize = getListSize(head);
        int s = listSize - k;
        ListNode temp=null;
        if(s>0) {
            temp = head;
            while (s > 0) {
                temp = temp.next;
                s--;
            }
        }

        return temp;
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
