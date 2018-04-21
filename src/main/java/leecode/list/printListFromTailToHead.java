package leecode.list;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-06-15.
 */
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        printList(listNode,list);
        return list;
    }


    public void printList(ListNode head,ArrayList<Integer> result){
        if(head==null) return;
        printList(head.next,result);
        result.add(head.val);
    }


}
