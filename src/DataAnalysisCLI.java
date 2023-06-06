import java.io.IOException;

/**
 * 
 * Implements a command line interface to:
 *  - ask the user for a csv filename
 *  - displays csv filename content
 *  - ask the user to select a column
 *  - displays column values with basic statistics
 *  
 *  Uses:
 *  - KeyboardReader for I/O
 *  - DataFrame to load csv data
 *  - DataSeries to calculate basic statistics.
 * 
 * @author Yves Pauchard
 *
 */
public class DataAnalysisCLI {
	
	private DataFrame data;
	private InteractiveCLI cli;

	public DataAnalysisCLI() {
		cli = new InteractiveCLI();
	}
	
	/**
	 * Implements the user dialog
	 */
	public void run() {
		cli.display("*** Basic statistics of csv columns ***");
		cli.prompt("  Enter a filename, e.g test.csv: ");
		String filename = cli.getKeyboardString();
		
		//DataFrame constructor may throw IOException
		// exit method if there is an error loading the csv file.
		try {
			data = new DataFrame(filename);
		}catch(IOException e) {
			cli.display(e.getMessage() + " - please try again.");
			return;
		}
		
		// Print information on data frame loaded from csv
		cli.display("shape=("+data.getNumOfRows()+", "+
							data.getNumOfCols()+")\n");
		cli.display(data.toString());
		
		
		// We ask the user to select a column
		cli.display("\n\n  Select a column by index:");
		String[] names = data.getHeaderNames();
		for(int i=0; i<names.length; i++) {
			cli.display(i+": "+names[i]);
		}
		cli.prompt("  Enter desired column index: ");
		int col = cli.getKeyboardInteger();
		
		//Checking if user selected a valid column index
		if(col>=0 && col < data.getNumOfCols()) {
			// Display the column and basic statistics
			DataSeries s = data.getColumnByIndex(col);
			
			cli.display(s.toString());
			cli.display("size = "+s.size());
			cli.display("min = "+s.getMin());
			cli.display("max = "+s.getMax());
			cli.display("sum = "+s.getSum());
			cli.display("mean = "+s.getMean());
			cli.display("*** END ***\n");
		}else {
			cli.display("Sorry "+col+" is not a valid column index.");
			cli.display("Please try again.");
		}
		
		
	}
	
	public static void main(String[] args) {
		DataAnalysisCLI app = new DataAnalysisCLI();
		app.run();

	}

}
