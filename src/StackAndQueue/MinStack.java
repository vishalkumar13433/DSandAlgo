package src.StackAndQueue;


import java.util.Stack;

public class MinStack {

	Stack<Integer> minStack , st;

	public MinStack() {
		minStack =  new Stack<>();
		st = new Stack<>();
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

	private int top() {
		if(st.isEmpty()){
			return -1;
		}
		return st.peek();
	}

	private void pop() {
		if(!st.isEmpty()){
			st.pop();
			minStack.pop();
		}
	}

	private int getMin() {
		if(minStack.isEmpty()){
			return -1;
		}
		return minStack.peek();
	}

	private void push(int element) {
		if(st.isEmpty()) {
			st.add(element);
			minStack.add(element);
		}else{
			st.add(element);
			minStack.add(Integer.min(element , minStack.peek()));
		}
	}

}