package leecode.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuomao on 2017-06-15.
 */
public class DeleteList {

    // 返回值的头节点
    public ListNode deleteNode(ListNode head,ListNode toDelete){
        if(head==null|| toDelete==null){
            return head;
        }
        // 被删除的节点是头节点
        if(head==toDelete){
            ListNode next=toDelete.next;
            toDelete=null;
            return next;
        }
        // 被删除的节点是尾部的节点
        if(toDelete.next==null){
            ListNode pre=head;
            while (pre.next!=toDelete){
                pre=pre.next;
            }
            pre.next=null;
            toDelete=null;
            return head;
        }
        // 被删除的节点是正常的节点
        ListNode next=toDelete.next;
        toDelete.val=next.val;
        toDelete.next=next.next;
        next=null;
        return  head;
    }



    public List<ListNode> createTestCase(){
        int[] vals={3,4,6,7,9,10};
        ListNode head=new ListNode(vals[0]);
        head.next=null;
        ListNode pre=head;
        List<ListNode> nodes=new ArrayList<>();
        nodes.add(head);
        for(int i=1;i<vals.length;i++){
            ListNode node=new ListNode(vals[i]);
            nodes.add(node);
            node.next=null;
            pre.next=node;
            pre=node;
        }
        return nodes;
    }


    @Test
    public  void testDeleteNode(){
        List<ListNode> nodes=createTestCase();

        // 删除头结点
        ListNode list=deleteNode(nodes.get(0),nodes.get(0));
        printList(list);

        nodes=createTestCase();
        list=deleteNode(nodes.get(0),nodes.get(2));
        printList(list);

        nodes=createTestCase();
        list=deleteNode(nodes.get(0),nodes.get(5));
        printList(list);

    }


    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}

class ListNode{
    public int val;
    public ListNode next=null;

    public ListNode(int val){
        this.val=val;
    }
}
