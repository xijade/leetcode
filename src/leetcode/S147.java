package leetcode;
//��Ϊû��ָ��ǰһ���ָ�룬���ԱȽ�ʱһ����t.next������t�������޷���ñȽ����ǰһ���nextָ�롣
//��tʱʵ�ʱȽϵ���t.next����������ͷҪ��һ��ͷ�����Ƚ�ʵ�ʵĵ�һ�
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
