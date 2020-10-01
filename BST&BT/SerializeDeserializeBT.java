import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeDeserializeBT {
	
	StringBuilder serial;
	SerializeDeserializeBT()
	{
		serial=new StringBuilder();
	}
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.right.left=new Node(4);
		bt.root.right.right=new Node(5);
		
		SerializeDeserializeBT b=new SerializeDeserializeBT();
		b.serialize(bt.root);
		System.out.println("Serialized BT is :" + b.serial);
		Node n=b.deserialize();
		preOrder(n);
	}

	private static void preOrder(Node n) {
		if(n==null)
			return;
		System.out.println(n.data);
		preOrder(n.left);
		preOrder(n.right);
	}

	private Node deserialize() {
		StringTokenizer st=new StringTokenizer(this.serial.toString()," ");
		return deserial(st);
	}


	private Node deserial(StringTokenizer st) {
		
		if(!st.hasMoreTokens())
			return null;
		String val=st.nextToken();
		if(val.equals("*"))
		{
			return null;
		}
		Node n=new Node(Integer.parseInt(val));
		n.left=deserial(st);
		n.right=deserial(st);
		return n;
	}

	private void serialize(Node root) {
		if(root==null)
		{
			this.serial.append('*' + " ");
			return;
		}
		this.serial.append(root.data + " ");
		serialize(root.left);
		serialize(root.right);
	}

}
