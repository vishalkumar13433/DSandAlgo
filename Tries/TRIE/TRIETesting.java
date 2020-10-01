package TRIE;

public class TRIETesting {
	public TRIENode root = null;
	public TRIETesting(){
		this.root = new TRIENode();
	}
	public static void main(String[] args) {
		TRIETesting trie = new TRIETesting();
		String[] strs = {"ana" , "ann","anna","anne"};
		for(String str : strs)	
			trie.FillStringInTrie(str.toCharArray());
		
		trie.printAllStrings(trie.root , "");
		
		String searchStr = "annae";
		boolean isPresent = trie.search(searchStr.toCharArray());
		if(isPresent) {
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}
		String prefix = "ann";
		boolean doesStartsWith = trie.startsWith(prefix.toCharArray());
		if(doesStartsWith) {
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}
	}
	
	 private boolean startsWith(char[] prefix) {
		 TRIENode temp = root;
	        for(char c:prefix) {
	        	if(temp.chars[c-'a'] == null) {
	        		return false;
	        	}
	        	temp  = temp.chars[c-'a'];
	        }
	        if(temp == null) return false;
	        if(temp.isWord) return true;
	        for(int i=0;i<temp.chars.length;i++) {
	        	if(temp.chars[i] != null) return true;
	        }
	        return false;
	}
	public boolean search(char[] word) {
		 	TRIENode temp = root;
	        for(char c:word) {
	        	if(temp.chars[c-'a'] == null) {
	        		return false;
	        	}
	        	temp  = temp.chars[c-'a'];
	        }
	        return (temp == null) ? false:temp.isWord;
	 }
	
	public void printAllStrings(TRIENode root , String str) {
		if(root.isWord) System.out.println(str);
		for(int i=0;i<root.chars.length;i++) {
			if(root.chars[i] != null)
				printAllStrings(root.chars[i] , str + (char) ('a' + i));
		}
	}
	public void FillStringInTrie(char[] str) {
		TRIENode temp = root;
		
		for(int i=0;i<str.length;i++) {
			if(temp.chars[str[i] - 'a'] == null) {
				temp.chars[str[i] - 'a'] = new TRIENode();
			}
			temp = temp.chars[str[i] - 'a'];
		}
		temp.isWord = true;
	}
	public void doDFSOnTRIE(TRIENode root , String str) {
		if(root==null) return;
		if(root.isWord) System.out.println(str);
		for(int i=0;i<root.chars.length;i++) {
			if(root.chars[i] != null) {
				doDFSOnTRIE(root.chars[i] , str+ (char) ('a'+i));
			}
		}
	}

}
