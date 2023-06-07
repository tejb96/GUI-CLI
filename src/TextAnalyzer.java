
/**
 * @author 
 *
 */
public class TextAnalyzer {
	private int numOfSentences=0;
	private int numOfWords=0;
	private int i = 0;
	
	public TextAnalyzer(String text) {
		while (i<text.length()){
			if(text.charAt(i)=='.'||text.charAt(i)=='?'||text.charAt(i)=='!') {numOfSentences++;}
			else if(text.charAt(i)==' '|| text.charAt(i)==',') {numOfWords++;}
			i++;
		}
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
