package leecode.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuomao on 2017-06-15.
 */
public class CloneList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cloneListHead = null;

        // 先顺序克隆节点，以及next节点
        cloneListHead = new RandomListNode(pHead.label);
        RandomListNode clonePre = cloneListHead;
        RandomListNode pre = pHead;
        while (pre.next != null) {
            RandomListNode node = new RandomListNode(pre.next.label);
            clonePre.next = node;

            pre = pre.next;
            clonePre = clonePre.next;
        }

        printList(cloneListHead);

        // 克隆Random节点
        RandomListNode node = pHead;
        RandomListNode cloneNode = cloneListHead;
        while (node != null) {
            RandomListNode randomListNode = node.random;
            if (randomListNode != null) {
                RandomListNode tempNode = pHead;
                RandomListNode cloneTemNode = cloneListHead;

                while (tempNode != null && tempNode != randomListNode) {
                    tempNode = tempNode.next;
                    cloneTemNode = cloneTemNode.next;
                }

                cloneNode.random = cloneTemNode;
            }

            node = node.next;
            cloneNode = cloneNode.next;
        }

        return cloneListHead;
    }

    public void printList(RandomListNode head){
        while (head!=null){
            System.out.print(head.label+" ");
            head=head.next;
        }
        System.out.println();
    }


    public RandomListNode createTestCase(){
        int[] vals={3,4,6,7,9,10};
        RandomListNode head=new RandomListNode(vals[0]);
        head.next=null;
        RandomListNode pre=head;
        List<RandomListNode> nodes=new ArrayList<>();
        nodes.add(head);
        for(int i=1;i<vals.length;i++){
            RandomListNode node=new RandomListNode(vals[i]);
            nodes.add(node);
            node.next=null;
            pre.next=node;
            pre=node;
        }

        int[] randomVals={2,1,3,-1,-1,2};

        RandomListNode node=head;

        for(int i=0;i<randomVals.length;i++){
            if(randomVals[i]==-1) node.random=null;
            else node.random=nodes.get(randomVals[i]);
            node=node.next;
        }

        return head;
    }

    public void printRandoms(RandomListNode head){
        while (head!=null){
            if(head.random==null) System.out.print("#,");
            else System.out.print(head.random.label+",");
            head=head.next;
        }
        System.out.println();
    }

    @Test
    public  void testCLone(){
        RandomListNode head=createTestCase();
        printRandoms(head);
        RandomListNode cloneHead=Clone(head);
        printRandoms(cloneHead);
    }




}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
