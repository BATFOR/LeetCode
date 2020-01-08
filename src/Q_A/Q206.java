package Q_A;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/9 1:20
 * @description
 **/
public class Q206 {
	public ListNode reverseList(ListNode head) {
		ListNode cur,prev,temp;
		cur = head;
		prev = null;
		while(cur!=null){
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

/* 经典Python解法
class Solution:
		def reverseList(self, head):
		"""
		:type head: ListNode
		:rtype: ListNode
		"""
		p, rev = head, None
		while p:
		rev, rev.next, p = p, rev, p.next
		return rev
*/
