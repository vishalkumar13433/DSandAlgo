package TRIE;

public class TRIENode {
	public boolean isWord;
	public TRIENode[] chars;
	
	public TRIENode() {
		isWord = false;
		chars = new TRIENode[26];
	}
	
}
