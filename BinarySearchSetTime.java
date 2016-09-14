package assignment03;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearchSetTime 
{
	
	public static void main(String[] args)
	{
		int N = 10000000;
		String bestCase = "best";
		String averageCase = "average";
		String worst = "worst";
		
		addTiming(N, bestCase);
		containsTiming(N);
		removeTiming(N);
	}
	
	public static void addTiming(int N, String conditions)
	{
		ArrayList<Integer> ranList = new ArrayList<Integer>();
		
		BinarySearchSet<Integer> binarySet;
		
		long start, end, total, avg;
		

		int numOfLoop = 1000;
		
		for(int i = 1; i <= N; i = 2*i)
		{	
			total = 0;			
		//reset random nums
		if(conditions.equals("average"))
			createRan(ranList, i);
		// reset binary set
		binarySet = new BinarySearchSet<Integer>();
				
		for(int j = 0; j < numOfLoop; j++)
		{
			start = System.nanoTime();
			if(conditions.equals("best"))
			{
			// 0 - (N-1)
				binarySet.add(j);
			}
			else if(conditions.equals("average"))
			{
				// ran order 0 - (N-1)
				binarySet.add(ranList.get(i));
			}
			else if(conditions.equals("worst"))
			{
				// (N-1) to 0
				binarySet.add(i - j);
			}
			end = System.nanoTime();
			
			total += end - start;
		}
		avg = total / numOfLoop;
		
			
		System.out.println("" + i + "\t" + avg);
		}
		
		
	}
	
	public static void containsTiming(int N)
	{
		
	}
	
	public static void removeTiming(int N)
	{
		
	}
	
	public static ArrayList<Integer> createRan(ArrayList<Integer> list, int N)
	{
		Random ran = new Random();
		int count = 0;
		while(count < N)
		{
			int ranNum = ran.nextInt(N);
			if(!list.contains(ranNum))
			{
				list.add(ranNum);		
				count++;
			}
			else
				continue;
		}
		
		return list;
	}
	
	public void createGraph()
	{
		
	}
}
