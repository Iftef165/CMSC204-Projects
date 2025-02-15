import java.util.ArrayList;
public class DataSetGen <T extends Measurable>{
	
	ArrayList<T> item;
	
	public DataSetGen()
	{
		item = new ArrayList<>();
	}
	
	public void add(T data)
	{
		item.add(data);
	}
	
	//gets the average by adding up all the data in th array
	public double getAverage()
	{
		double sum = 0;
		for(int i=0;i<item.size();i++)
		{
			sum+=item.get(i).getMeasure();
		}
		
		return sum/ item.size();
	}
	
	//loops through the array to find the highest balance for the generic 
	public T getMaximum()
	{
		T maximum = item.get(0);
		
		for(int i=0;i<item.size();i++)
		{
			if(maximum.getMeasure() < item.get(i).getMeasure())
			{
				maximum = item.get(i);
			}
		}
		
		return maximum;
	}
	
	
}
