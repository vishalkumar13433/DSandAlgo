package src.StackAndQueue;

public class learnQueue {
	int size=5;
	int a[]=new int[size];
	int rear,front;
	learnQueue()
	{
		this.rear=-1;
		this.front=-1;
	}
	public static void main(String[] args) {
		learnQueue q=new learnQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println("Front is:"+q.front);
		System.out.println("rear is:"+q.rear);
		System.out.println("Dequeing:"+q.dequeue());
		
	}
	private void enqueue(int val) {
		if(isFull())
		{
			System.out.println("Queue is full!! cannot add");
			return;
		}
		if(isEmpty())
		{
			front++;
		}
		rear=rear+1;
		
		a[rear]=val;
		System.out.println(val+ " enqueued to queue"); 
	}
	
	private int dequeue() {
		if(isEmpty())
		{
			System.out.println("Queue is Empty!! cannot remove");
			return -1;
		}
		return a[front++];
	}
	
	private int front() {
		if(isEmpty())
		{
			System.out.println("Queue is Empty!!");
			return -1;
		}
		return a[front];
	}
	
	private int rear() {
		
		if(isEmpty())
		{
			System.out.println("Queue is Empty!!");
			return -1;
		}
		return a[rear];
	}
	
	private boolean isFull() {
		return rear==size-1;
	}
	
	
	
	
	private boolean isEmpty() {
	
		return (front==-1 && rear==-1)|| (front>rear);
	}

}
