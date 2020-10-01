package GraphTheory.Questions;

public class Boggle {

	public static void main(String args[]) 
    { 
		Boggle bog = new Boggle();
        // Let the given dictionary be following 
        String dictionary[] = {"geeks", "for", "quiz", "go"}; 
       
        // root Node of trie 
       
        // insert all words of dictionary into trie 
        int n = dictionary.length; 
        char boggle[][] = {{'g','i','z'}, 
                           {'u','e','k'}, 
                           {'q','s','e'} 
        }; 
        
        bog.findWords(boggle); 
               
    }

	private void findWords(char[][] boggle) {
		// TODO Auto-generated method stub
		
	}
	
}
