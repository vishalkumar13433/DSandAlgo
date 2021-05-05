package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class implementStackusingQueue {
	Queue<Integer> q=new LinkedList<>();
    
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        int size=q.size();
        for(int i=0;i<size-1;i++)
        {
            q.add(q.peek());
            q.poll();
        }
    }
    
    public int pop() {
            return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
	public static void main(String[] args) {
		implementStackusingQueue stack=new implementStackusingQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
	}

}
