package Arrays.Strings;

public class StringProperties {
	
	public static void main(String[] args)
	{
		String s="Vishal";
		System.out.println(s);
		s="Kumar"; // This statement will make str 
        // point to new String constant("Kumar")
        // rather than modifying the previous 
        // String constant.
		System.out.println(s);
	}
}
