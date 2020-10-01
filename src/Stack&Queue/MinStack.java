

import java.util.Stack;

public class MinStack {
	Stack<Integer> st,minStack;
	/** initialize your data structure here. */
	public MinStack() {
		st = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		if(minStack.isEmpty()) {
			minStack.push(x);
		}else {
			int min = minStack.peek();
			minStack.push(Integer.min(min, x));
		}
		st.push(x);
	}

	public void pop() {
		if(!st.isEmpty()) {
			st.pop();
			minStack.pop();
		}
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		int param_4 = obj.getMin();
		System.out.println(param_4);
		obj.pop();
		int param_3 = obj.top();
		System.out.println(param_3);
		param_4 = obj.getMin();
		System.out.println(param_4);
	}

}