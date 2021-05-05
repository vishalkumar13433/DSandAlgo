package GraphTheory;

import GraphTheory.GraphRepresentation.GraphUsingAdjacencyList;
import GraphTheory.graphTraversal.TopologicalSort;

public class OrderOfAlphabetsInAlienLanguageDictionary {

	public static void main(String[] args) 
    { 
        String[] words = {"baa", "abcd", "abca" , "cab" , "cad"}; 
        printOrder(words, 4); 
    }

	private static void printOrder(String[] words, int alphabets) {
		GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(alphabets);	//graph of number of alphabets in the language
		for(int i=0; i< words.length - 1 ; i++ ) {
			String word1 = words[i];
			String word2 = words[i+1];
			
			for(int j = 0 ; j< Integer.min(word1.length(), word2.length()); j++) {
				if(word1.charAt(j) != word2.charAt(j)) {
					g.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
					break;
				}
			}
			
		}
		TopologicalSort.topologicalSort(g);
	} 
	
}
