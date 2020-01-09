package Q_A;

import java.util.Stack;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/10 1:13
 * @description 用栈实现队列
 **/
public class Q232 {

}
class MyQueue {
	Stack<Integer> stackIn,stackOut;
	/** Initialize your data structure here. */
	public MyQueue() {
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stackIn.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(stackOut.empty())
			while(!stackIn.empty()){
				stackOut.push(stackIn.pop());
			}
		return stackOut.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(stackOut.empty())
			while(!stackIn.empty()){
				stackOut.push(stackIn.pop());
			}
		return stackOut.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if(stackOut.empty())
			while(!stackIn.empty()){
				stackOut.push(stackIn.pop());
			}
		return stackOut.empty();
	}
}