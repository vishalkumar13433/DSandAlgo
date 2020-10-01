
public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 3; 
        towerOfHanoi(n, 'A', 'C', 'B');
	}

	private static void towerOfHanoi(int n, char From, char To, char Aux) {
		if(n==1)
		{
			System.out.println("Moving disk1 from "+From+" to " + To);
			return;
		}
		towerOfHanoi(n-1,From,Aux,To);
		System.out.println("Moving disk "+n +" from "+From+" to " + To);
		towerOfHanoi(n-1,Aux,To,From);
	}

}
