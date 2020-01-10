import java.util.PriorityQueue;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/10 19:42
 * @description
 **/
public class Q215 {
}

class Solution {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);
		for(int i=0;i<nums.length;++i){
			if(queue.size()>=k){
				if(nums[i]>queue.peek()){
					queue.poll();
					queue.add(nums[i]);
				}
			}else{
				queue.add(nums[i]);
			}
		}
		return queue.peek();
	}
}