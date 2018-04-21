package leecode.list;

import org.junit.Test;

import java.util.HashMap;

import static leecode.list.DeleteList.printList;

/**
 * Created by tuomao on 2017-06-15.
 */
public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        // 第一步统计每一个值出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode node = pHead;
        while (node != null) {
            if(map.containsKey(node.val))  map.put(node.val, map.get(node.val) + 1);
            else map.put(node.val, 1);

            node=node.next;
        }

        // 第二步，对于次数大于1的节点删除

        // 寻找新的头节点
        while (pHead != null && map.get(pHead.val) > 1) {
            pHead = pHead.next;
        }

        if (pHead == null) return null;

        ListNode pre = pHead;
        while (pre.next != null) {
            // 要删除
            if (map.get(pre.next.val) > 1) pre.next = pre.next.next;
            else pre = pre.next;// 不删除
        }
        return pHead;
    }

    public ListNode createTestCase(){
        int[] vals={3,3,6,7,6,7};
        ListNode head=new ListNode(vals[0]);
        head.next=null;
        ListNode pre=head;

        for(int i=1;i<vals.length;i++){
            ListNode node=new ListNode(vals[i]);

            node.next=null;
            pre.next=node;
            pre=node;
        }
        return head;
    }


    @Test
    public void testDelete(){
        ListNode head=createTestCase();
        head=deleteDuplication(head);
        printList(head);

    }
}
