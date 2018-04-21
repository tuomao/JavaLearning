package leecode.list;

/**
 * Created by tuomao on 2017-06-15.
 */
public class FindFirstCommonNode {
    /**
     * 思路：如果两个链表具有一个重合的节点，那么他们具有相同的尾部节点，尾部节点的数量相同
     *
     * 1. 求解出两个链表的长度
     * 2. 对于长的链表，先走他们的差值的步数
     * 3. 走到相同的节点，那么就是其重合的节点
     *
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return  null;

        int len1=0,len2=0;
        ListNode node1=pHead1,node2=pHead2;
        while (node1!=null){
            node1=node1.next;
            len1++;
        }

        while (node2!=null){
            node2=node2.next;
            len2++;
        }

        node1=pHead1;
        node2=pHead2;

        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                node1=node1.next;
            }
        }

        if(len2>len1){
            for (int i=0;i<len2-len1;i++) node2=node2.next;
        }

        while (node1!=node2 &&node1!=null &&node2!=null){
            node1=node1.next;
            node2=node2.next;
        }

        return node1;
    }
}
