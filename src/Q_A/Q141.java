package Q_A;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/9 17:14
 * @description
 **/
public class Q141 {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head,fast = head;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
}
