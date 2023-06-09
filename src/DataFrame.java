import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * Represents a DataFrame that holds tabular data, provides methods to read data from a file and retrieve information about the loaded data.
 * 
 * 
 * @author Tej Bal
 *
 */
public class DataFrame {
	private String[] headerNames;
	private int numOfRows, numOfCols;
	private double[][] data;
	 
	/**
     * Constructs a DataFrame by reading data from a file.
     *
     * @param file the file path to read data from
     * @throws FileNotFoundException if the file is not found
     */
	public DataFrame(String file) throws FileNotFoundException {
		 
		 File text = new File(file);
		 Scanner reader = new Scanner(text);
		 
		 if (reader.hasNextLine()) {
            String headerLine = reader.nextLine();
            headerNames = headerLine.split(",");
            numOfCols = headerNames.length;
            }
         
		 
		 data = new double[100][numOfCols];
	
		 numOfRows = 0;
		 while (reader.hasNextLine() && numOfRows < 100) {			 
			 String dataLine = reader.nextLine();
			 String[] dataValues = dataLine.split(",");
			 
			 for (int i = 0; i < numOfCols; i++) {
			     data[numOfRows][i] = Double.parseDouble(dataValues[i]);
			 }
		     numOfRows++;
		 }
			
		 reader.close();        
	 }
	 
	 /**
     * Returns an array of header names.
     *
     * @return the header names
     */
	public String[] getHeaderNames() {
     	return headerNames;
    }
	 
	/**
     * Retrieves a DataSeries representing a column in the DataFrame based on the given index.
     *
     * @param index the index of the column
     * @return the DataSeries representing the column
     * @throws IndexOutOfBoundsException if the index is invalid
     */
	 public DataSeries getColumnByIndex(int index) {
		 if (index < 0 || index >= numOfCols) {
             throw new IndexOutOfBoundsException("Invalid column index");
         }
		 
		 String columnName = headerNames[index];
		 DataSeries column = new DataSeries(columnName);
		 double columnData = 0;
		 
	     for (int i = 0; i < numOfRows; i++) {
	         columnData = data[i][index];
	         column.add(columnData);
	     }
	     return column;
 	 }
	 
	 /**
      * Returns the number of rows in the DataFrame.
      *
      * @return the number of rows
      */
	 public int getNumOfRows() {return numOfRows;}
	 
	 /**
      * Returns the number of columns in the DataFrame.
      *
      * @return the number of columns
      */
	 public int getNumOfCols() {return numOfCols;}
	 
	 /**
      * Returns a string representation of the DataFrame.
      * The string includes the header names and a subset of the data rows.
      *
      * @return a string representation of the DataFrame
      */
	 @Override
	 public String toString() {
	     StringBuilder sb = new StringBuilder();
	     // Append header names
		 for (String headerName : headerNames) {
		     sb.append(headerName).append("\t");
	 	 }
		 sb.append("\n");
	
		// Append data rows (up to 10 rows)
		
		 for (int i = 0; i < numOfRows && i< 10; i++) {
		     for (int j = 0; j < numOfCols; j++) {
		         sb.append(data[i][j]).append("\t");
		     }
		     sb.append("\n");
		     if (numOfRows > 10 && i == 9) {
			        sb.append(".\n.\n."+ "\n");
			 }
		 }
		    return sb.toString();
		
	  }

}

