package leetcode;

class s2 {
	public class ListNode {
		 int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		  }
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
    }
    
    public static void main(String args[]) {
    	s2 s = new s2();
    	ListNode a = s.new ListNode(3);
    	ListNode b = s.new ListNode(4);
    	a.next = s.new ListNode(4);
    	b.next = s.new ListNode(6);
    	a.next.next = s.new ListNode(1);
    	ListNode c = s.addTwoNumbers(a, b);
    	while(c != null) {
    		System.out.print(c.val);
    		c = c.next;
    	}
    	
    	
    }
}

