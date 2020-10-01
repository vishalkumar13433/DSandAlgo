package Strings;
import java.util.*;
import java.util.Map.Entry;

public class permutationOfString {

	public static void main(String[] args) {
		String input="AABC";
		char[] in=input.toCharArray();
		permute(in);
	}

	private static void permute(char[] in) {
		Map<Character,Integer> m =new TreeMap();
		int len=in.length;
		//taking characters and their count in map
		for(int i=0;i<len;i++)
		{
			if(m.get(in[i])==null)
				m.put(in[i], 1);
			else
				m.put(in[i], m.get(in[i])+1);
		}
		char str[]=new char[m.size()];
		char res[]=new char[len];
		int count[]=new int[m.size()];
		
		int index=0;
		for(Entry<Character,Integer> e:m.entrySet())
		{
			str[index]=e.getKey();
			count[index]=e.getValue();
			index++;
		}
		permuteUtil(str,count,res,0);
	}

	private static void permuteUtil(char[] str, int[] count, char[] res, int level) {
		if(level==res.length)
		{
			printArray(res);
			return;
		}
		
		
		for(int i=0;i<str.length;i++)
		{
			if(count[i]==0)
					continue;
			//choose
			res[level]=str[i];
			
			//exploring
			count[i]--;
			
			permuteUtil(str,count,res,level+1);
			
			//Unexploring
			count[i]++;
		}
		
	}

	private static void printArray(char[] res) {
		for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i]);
		}
		System.out.print("\n");
	}

}
