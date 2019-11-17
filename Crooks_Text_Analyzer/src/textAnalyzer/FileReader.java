package textAnalyzer;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * This is the File Reader class that reads in the txt file and splits the lines
 * of text into a string array and puts that string array into a linked list.
 * 
 * @author Dakota Crooks
 * @date September 15th 2019
 * @program Crooks_Text_Analyzer
 * 
 * 
 * 
 */
public class FileReader {

	private Scanner scan;
	private File text;
	private LinkedList<String> words = new LinkedList();

	/**
	 * Opens the file from the specified location
	 */
	public void openFile() {
		try {
			text = new File("src/textAnalyzer/MacBeth.txt");
			scan = new Scanner(text);
		} catch (Exception e) {
			System.out.println("could not find file");
			File file = new File(".");
			for (String fileNames : file.list())
				System.out.println(fileNames);
		}

	}

	/**
	 * Reads the file that was scanned and adds lines to words linked list
	 */
	public void readFile() {

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] lines = line.split(" ");
			for (int i = 0; i < lines.length; i++) {
				// System.out.println("add "+lines[i]);
				words.add(lines[i]);

			}

		}

	}

	/**
	 * @return words the LinkedList that holds all the words in the file
	 */
	public LinkedList<String> getWords() {
		return words;

	}

	/**
	 * Closes File Stream
	 */
	public void closeFile() {
		scan.close();
	}

}
