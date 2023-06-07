import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The TextAnalyzer class is responsible for analyzing text and counting the number of sentences and words.
 * 
 * 
 * @author Tej
 *
 */
public class TextAnalyzer {
	private int numOfSentences=0;
	private int numOfWords=0;
	
	/**
	 * Constructs a TextAnalyzer object and analyzes the given text.
	 *
	 * @param text the text to be analyzed
	 */
	public TextAnalyzer(String text) {
		Pattern wordPattern = Pattern.compile("\\S+"); // Matches non-space sequences of characters
		Matcher wordMatcher = wordPattern.matcher(text);
		while(wordMatcher.find()) {numOfWords++;}	
		
		Pattern sentencePattern = Pattern.compile("\\.|\\!|\\?"); // Matches all ., ?, and !
		Matcher sentenceMatcher = sentencePattern.matcher(text);		
		while(sentenceMatcher.find()) {numOfSentences++;}
	}
	
	/**
	 * Returns the number of sentences in the analyzed text.
	 *
	 * @return the number of sentences
	 */
	public int getNumOfSentences(){
		return numOfSentences;
	}
	
	/**
	 * Returns the number of words in the analyzed text.
	 *
	 * @return the number of words
	 */
	public int getNumOfWords(){
		return numOfWords;
	}
	
	/**
	 * Returns a string representation of the analysis results.
	 *
	 * @return a string with the number of sentences and words
	 */
	@Override
	public String toString() {
		return "The number of sentences: "+ numOfSentences + " and the number of words: "+ numOfWords;
	}

}
