package coins;

import java.util.ArrayList;

public class Coins 
{	
	public int getMax(int value, int []demonition)
	{
		if(value == 0)
			return 0;
		for(int i = demonition.length-1;i > 0;i--)
		{
			if(demonition[i] <= value)
				return demonition[i];
		}
		return value;
	}
	
	public void minCoins(int value,int []demonition)
	{
		ArrayList<Integer> a = new ArrayList<>();
		int sum = value;
		while(sum > 0)
		{
			int max = getMax(sum, demonition);
			if(max != 0)
				a.add(max);
			sum -= max;
		}
		
		for(int i : a)
			System.out.print(i + " ");
	}
}
