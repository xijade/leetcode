package leetcode;
//因为没有指向前一项的指针，所以比较时一定是t.next而不是t，否则无法获得比较项的前一项的next指针。
//用t时实际比较的是t.next。所以链表头要加一个头，来比较实际的第一项，
public class S147 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode t = head;
        ListNode p;
        int del_tag;
        while(t.next != null) {
        	
        	ListNode cur = first;
        	del_tag = 0;
        	while(t != cur ) {
        		if(t.next.val < cur.next.val) {
        			p = t.next;
        			
        			t.next = t.next.next;
        			p.next = cur.next;
        			cur.next = p;
        			del_tag = 1;
        			break;
        		}else {
        			cur = cur.next;
        		}
        	}
        	if(del_tag == 0)
        	    t = t.next;
        }
        return first.next;
    
    }
    
}
