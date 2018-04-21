package leecode.list;

import java.util.HashSet;

/**
 * Created by tuomao on 2017-06-15.
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null) return null;

        HashSet<ListNode> visitedNode=new HashSet<>();
        while (pHead!=null){
            if(pHead.next!=null){
                if(visitedNode.contains(pHead.next)) return pHead.next;
            }
            
            visitedNode.add(pHead);
            pHead=pHead.next;

        }

        return null;

    }
}
