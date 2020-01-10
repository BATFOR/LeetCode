import java.util.PriorityQueue;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/10 15:37
 * @description
 **/
public class Q703 {

}
class KthLargest {
	PriorityQueue<Integer> queue;
	int k;
	public KthLargest(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<>(k);
		for(int i=0;i<nums.length;++i){
			add(nums[i]);
		}
	}

	public int add(int val) {
		if(queue.size()>=k){
			if(val>queue.peek()){
				queue.poll();
				queue.add(val);
			}
		}else{
			queue.add(val);
		}
		return queue.peek();
	}
}