package Arrays.Strings;


public class findColumnNameinExcel {

	public static void main(String[] args) 
    { 
		printString(26); 
        printString(51); 
        printString(52); 
        printString(80); 
        printString(676); 
        printString(702); 
        printString(705); 
    }

	private static void printString(int num) {
		StringBuilder columnName = new StringBuilder(); 
		
		//Logic
		while (num > 0) {
			int rem = num % 26;
			if (rem == 0) {
				num = num/26 - 1;
				columnName.append('Z');
			} else {
				columnName.append((char)('A' + rem - 1));
				num = num/26;
			}
		}
		System.out.println(columnName.reverse());
	} 
	
}
