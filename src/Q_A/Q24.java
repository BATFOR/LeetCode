package Q_A;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/9 14:11
 * @description
 **/
public class Q24 {

	public ListNode swapPairs(ListNode head) {
		if(head == null) return head;
		ListNode cur,prev;
		int t;
		cur = head.next;
		prev = head;
		while(cur!=null){
			t = cur.val;
			cur.val = prev.val;
			prev.val = t;

			prev = cur.next;
			if(prev == null) break;
			cur = prev.next;
			if(cur==null) break;
		}
		return head;
	}

	public ListNode swapPairs_B(ListNode head) {
		ListNode temp;
		if(head == null || head.next == null) return head;
		temp = head.next;
		head.next = swapPairs_B(temp.next);
		temp.next = head;
		return temp;
	}
	public ListNode swapPairs_C(ListNode head) {
		ListNode temp,temp1,temp2,h;
		if(head == null) return head;
		h = head.next;  if(h == null) return head;
		while(head!=null&&head.next!=null){
			temp = head.next;
			temp1 = temp.next;
			if(temp1!=null){
				temp2 = temp1.next;
			}else{
				temp2 = null;
			}
			temp.next = head;
			if(temp2!=null)
				head.next = temp2;
			else
				head.next = temp1;

			head = temp1;

		}
		return h;
	}

}
