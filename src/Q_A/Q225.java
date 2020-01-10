package Q_A;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李嘉豪, 1316374518@qq.com
 * @createTime 2020/1/10 1:30
 * @description
 **/
public class Q225 {
}
class MyStack {
	Queue<Integer> queueIn,queueOut;
	/** Initialize your data structure here. */
	public MyStack() {
	 queueIn = new LinkedList<Integer>();
	 queueOut = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queueIn.offer(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if(queueIn.size()>1)
		{
			while(queueIn.size()>1){
				queueOut.offer(queueIn.poll());
			}
		}
		int result = queueIn.poll();
		Queue<Integer> temp = queueIn;
		queueIn = queueOut;
		queueOut = temp;

		return result;
	}

	/** Get the top element. */
	public int top() {
		if(queueIn.size()>1)
		{
			while(queueIn.size()>1){
				queueOut.offer(queueIn.poll());
			}
		}
		int result = queueIn.peek();
		queueOut.offer(queueIn.poll());
		Queue<Integer> temp = queueIn;
		queueIn = queueOut;
		queueOut = temp;

		return result;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queueIn.isEmpty();
	}
}

class MyStack_B {
	Queue<Integer> queueIn,queueOut;
	/** Initialize your data structure here. */
	public MyStack_B() {
		queueIn = new LinkedList<Integer>();
		queueOut = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queueIn.offer(x);
		while(!queueOut.isEmpty()){
			queueIn.offer(queueOut.poll());
		}

		Queue<Integer> temp = queueIn;
		queueIn = queueOut;
		queueOut = temp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queueOut.poll();
	}

	/** Get the top element. */
	public int top() {
		return queueOut.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queueOut.isEmpty();
	}
}
