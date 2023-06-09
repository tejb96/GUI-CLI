
/**
 * Represents a series of data points and provides methods to calculate basic statistics, the data series can store up to 100 values.
 * 
 * @author Tej Bal
 *
 */
public class DataSeries implements IBasicStats {
	private String label;
	private double[] data;
	private int count;

	/**
    * Constructs a DataSeries with the specified label.
    *
    * @param label the label for the DataSeries
    */
	public DataSeries(String label) {
		this.label = label;
		data = new double[100];
		count = 0;
	}
	
	/**
    * Adds a value to the DataSeries.
    *
    * @param value the value to add
    * @throws IllegalStateException if the DataSeries is full
    */
	public void add(double value) {
		if(count<data.length) {
			data[count]=value;
			count++;
		}
		else {
			throw new IllegalStateException("Dataseries is full");
		}
	}
	
	/**
    * Returns the number of values in the DataSeries.
    *
    * @return the size of the DataSeries
    */
	public int size() {
	     return count;
	}
	
	/**
    * Calculates and returns the minimum value in the DataSeries.
    *
    * @return the minimum value
    * @throws IllegalStateException if the DataSeries is empty
    */
	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		if (count == 0) {
            throw new IllegalStateException("DataSeries is empty");
        }

        double min = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
	}
	
	/**
    * Calculates and returns the maximum value in the DataSeries.
    *
    * @return the maximum value
    * @throws IllegalStateException if the DataSeries is empty
    */
	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		if (count == 0) {
            throw new IllegalStateException("DataSeries is empty");
        }

        double max = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
	}

	/**
    * Calculates and returns the sum of all values in the DataSeries.
    *
    * @return the sum of values
    * @throws IllegalStateException if the DataSeries is empty
    */
	@Override
	public double getSum() {
		// TODO Auto-generated method stub
		if (count == 0) {
            throw new IllegalStateException("DataSeries is empty");
        }

        double sum = data[0];
        for (int i = 1; i < count; i++) {
            
               sum += data[i];
            
        }
        return sum;
	}


	/**
    * Calculates and returns the mean of all values in the DataSeries.
    *
    * @return the mean of values
    * @throws IllegalStateException if the DataSeries is empty
    */
	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		if (count == 0) {
            throw new IllegalStateException("DataSeries is empty");
        }

        double sum = data[0];
        for (int i = 1; i < count; i++) {
            
               sum += data[i];
            
        }
        return sum/count;
	}
	
	/**
     * Returns a string representation of the DataSeries, the string includes the header names and a subset of the data rows.
     *
     * @return a string representation of the DataSeries
     */
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(label).append(": ");
        for (int i = 0; i < count && i < 10; i++) {
            sb.append(data[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
