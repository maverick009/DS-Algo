package subseq;

public class Subseq 
{
	public int lis(int []a)
	{
		if(a.length == 1)
			return 1;
		int max = 1;
		int []lis = new int[a.length];
		for(int i = 0;i < a.length;i++)
			lis[i] = 1;
		
		for(int i = 1;i < a.length;i++)
		{
			for(int j = 0;j < i;j++)
			{
				if(a[i] > a[j] && (lis[i] < lis[j] + 1))
					lis[i] = lis[j] + 1;
			}
		}
		
		for(int i = 0;i < lis.length;i++)
		{
			if(max < lis[i])
				max = lis[i];
		}
		return max;		
	}
}