package textAnalyzer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

/**
 * This is the main method class that calls the file reader and sorts the list
 * into the map
 * 
 * @author Dakota Crooks
 * @date September 15th 2019
 * @program Crooks_Text_Analyzer
 */
public class TextAnalyzerMain {

	/**
	 * Main Method for the Program that makes objects, calls methods, and prints
	 * results.
	 * 
	 * @param args
	 *            standard String args array
	 */
	public static void main(String[] args) {

		String scrollwords = null;
		// TODO Auto-generated method stub
		FileReader r = new FileReader();
		r.openFile();
		r.readFile();
		r.closeFile();
		Map<String, Integer> sortedWords = new HashMap<String, Integer>();
		ValueComparator bvc = new ValueComparator(sortedWords);
		TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);

		LinkedList<String> words = r.getWords();

		sortedWords.putAll(sortwords(words));

		// for (int i = 0; i < words.size(); i++) {
		// if (sortedWords.containsKey(words.get(i)) == true) {
		// sortedWords.put(words.get(i), sortedWords.get(words.get(i)) + 1);
		// } else {
		// sortedWords.put(words.get(i), 1);
		// }
		// }

		sorted_map.putAll(sortedWords);
		for (Entry<String, Integer> entry : sorted_map.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
			scrollwords = (scrollwords + entry.getKey() + "  " + entry.getValue() + " \n");
		}

	}

	/**
	 * populates the Map with the values from the linkedlist.
	 * 
	 * @param words
	 *            the words variable from the FileReader
	 * 
	 * @return sortedWords words but sorted with proper counts
	 **/
	public static Map<String, Integer> sortwords(LinkedList<String> words) {
		Map<String, Integer> sortedWords = new HashMap<String, Integer>();
		for (int i = 0; i < words.size(); i++) {
			if (sortedWords.containsKey(words.get(i)) == true) {
				sortedWords.put(words.get(i), sortedWords.get(words.get(i)) + 1);
			} else {
				sortedWords.put(words.get(i), 1);
			}
		}

		return sortedWords;

	}

}

/**
 * the function of this class is to sort the Hash map into a tree map by value.
 * 
 * @author Dakota Crooks
 * @date September 15th 2019
 * @program Crooks_Text_Analyzer
 * 
 */
class ValueComparator implements Comparator<String> {
	Map<String, Integer> base;

	/**
	 * Constructor for the ValueComparator class
	 * 
	 * @param base
	 */
	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
	}

	public int compare(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		}
	}

}
