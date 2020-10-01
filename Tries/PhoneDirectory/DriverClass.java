package PhoneDirectory;

import TRIE.TRIENode;
import TRIE.TRIETesting;

public class DriverClass {

	public static void main(String args[]) 
    { 
		DriverClass dc = new DriverClass();
		TRIETesting trie = new TRIETesting(); 
  
        String contacts [] = {"gforgeeks", "geeksquiz"}; 
        for(String contact: contacts) {
            trie.FillStringInTrie(contact.toCharArray()); 
        }
        String query = "gek"; 
  
        // Note that the user will enter 'g' then 'e' so 
        // first display all the strings with prefix as 'g' 
        // and then all the strings with prefix as 'ge' 
        dc.displayContacts(trie,query.toCharArray()); 
    }

	private void displayContacts(TRIETesting trie, char[] query) {
		TRIENode temp = trie.root;
		if(query.length ==0 || temp == null) return;
		for(char c:query) {
			temp = temp.chars[c-'a'];
			if(temp == null) return;
		}
		trie.doDFSOnTRIE(temp,String.valueOf(query));
	} 
	
}
