package leecode.Merge;

/**
 * Created by tuomao on 2017-03-03.
 */
public class Solution {
    ListNode head=null,curNode=null;

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1=solution.genList(1);
        ListNode list2=solution.genList(3);
        ListNode listNode=solution.Merge(list1,list2);
        ListNode temp=listNode;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }

    }

    public ListNode genList(int number){

        ListNode list=null,preNode=null;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i+number);
            node.next = null;
            if(list==null){
                list=node;
            }else {
                preNode.next = node;
            }
            preNode=node;
        }
        return list;
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode temp1=list1,temp2=list2;

        while (temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                addNode(temp1);
                temp1=temp1.next;
            }else{
                addNode(temp2);
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            addNode(temp1);
            temp1=temp1.next;
        }

        while (temp2!=null){
            addNode(temp2);
            temp2=temp2.next;
        }
        return head;
    }

    public void addNode(ListNode node){
        if(head==null){
            head=node;
            curNode=head;
        }else{
            curNode.next=node;
            curNode=curNode.next;
        }
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
