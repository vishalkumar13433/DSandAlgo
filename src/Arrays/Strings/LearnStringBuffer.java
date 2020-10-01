package Arrays.Strings;

public class LearnStringBuffer {

	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Vishal");
		StringBuffer s1=new StringBuffer();
		//LENGTH vs CAPACITY
		System.out.println(s1.capacity());	//16 default
		System.out.println(s.length());		//size of string : 6
		System.out.println(s.capacity());	//16+ size of string given i.e. 16+6=22
		
		//Append vs Insert
		System.out.println(s);
		s.append(" Kumar");
		System.out.println(s);
		s.insert(6, "Cool");
		System.out.println(s);
		
		//Inseting using char array vs String
		char []c= {'M','A','R','I','K'};
		s.insert(6, c);
		s.insert(11,".3");
		System.out.println(s);
		
		//Delete vs DeleteCharAt
		s.delete(6, 13);
		System.out.println(s);
		s.deleteCharAt(10);
		System.out.println(s);
		
		s.replace(6,10,"Marik");
		System.out.println(s);
		
		//reversing stringbuffer
		s1=s;
		s1.reverse();
		System.out.println(s1);
		
		StringBuffer s3=new StringBuffer("Vishal");
		StringBuffer s4=new StringBuffer("Vishal");
		
		StringBuilder s5=new StringBuilder("Vishal");
		StringBuilder s6=new StringBuilder("Vishal");
		StringBuilder s7=new StringBuilder();
		s7.append(1);
		System.out.println(s3.equals(s4));
		System.out.println(s5.equals(s6));
	}

}
