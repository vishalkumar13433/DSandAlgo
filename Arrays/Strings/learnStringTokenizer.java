package Strings;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

public class learnStringTokenizer {

	public static void main(String[] args) {
		String s="Hey bud time to switch";
		StringTokenizer st=new StringTokenizer(s);
		StringTokenizer st2 = new StringTokenizer("JAVA : Code : String", " :"); 
		ArrayList<String> a=new ArrayList<>();
		while(st.hasMoreTokens())
		{
			a.add(st.nextToken());
		}
		java.util.Iterator<String> i=a.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		a.clear();
		while(st2.hasMoreTokens())
		{
			a.add(st2.nextToken());
		}
		java.util.Iterator<String> it=a.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
