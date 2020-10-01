package Arrays;

public class TOurPetrolPump {

	public static void main(String[] args) {
		int[] gas = {5,1,2,3,4};
		int[] cost = {4,4,1,5,1};

		System.out.println(canCompleteCircuit(gas , cost));
	}
	
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
		 int start = 0 , petrolInHand = 0 , totalGasLeftTillNow = 0;
		 for(int i=0;i<gas.length;i++) {
			 petrolInHand += (gas[i] - cost[i]);
			 totalGasLeftTillNow += (gas[i] - cost[i]);
			 if(petrolInHand < 0) {
				 petrolInHand = 0;
				 start = i+1;
			 }
		 }
		 return (totalGasLeftTillNow >= 0) ? start : -1;
	 }

}
