package textAnalyzer;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.Test;

/**
 * 
 * This is a junit test that tests the sortWords method in the TextAnalyzer
 * Class.
 * 
 * @author Dakota Crooks
 * @Date 10/25/2019
 * @Program Crooks_Text_Analyzer
 * 
 */
public class TextAnalyzerTest {
	/**
	 * Tests the TextAnalyzer class methods
	 */
	@Test
	public void test() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		TextAnalyzerMain test = new TextAnalyzerMain();
		LinkedList<String> words = new LinkedList<String>();
		for (int i = 0; i < 10; i++) {
			words.add("A");
		}
		for (int j = 0; j < 5; j++) {
			words.add("B");
		}
		map.putAll(TextAnalyzerMain.sortwords(words));
		if (map.get("A") != 10) {
			fail("A count incorrect");
		}
		if (map.get("B") != 5) {
			fail("B count incorrect");
		}

	}

}
