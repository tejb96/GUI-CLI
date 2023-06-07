import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 
 *
 */
public class TextAnalyzer {
	private int numOfSentences=0;
	private int numOfWords=0;
	
	
	
	public TextAnalyzer(String text) {
		Pattern wordPattern = Pattern.compile("\\S+");
		Matcher wordMatcher = wordPattern.matcher(text);
		
		Pattern sentencePattern = Pattern.compile("\\.|\\!|\\?");
		Matcher sentenceMatcher = sentencePattern.matcher(text);
		
		while(wordMatcher.find()) {numOfWords++;}
	
	
		while(sentenceMatcher.find()) {numOfSentences++;}
	}
	
	public int getNumOfSentences(){
		return numOfSentences;
	}
	
	public int numOfWords(){
		return numOfWords;
	}
	
	public String toString() {
		return "The number of sentences: "+ numOfSentences + " and the number of words: "+ numOfWords;
	}

}
