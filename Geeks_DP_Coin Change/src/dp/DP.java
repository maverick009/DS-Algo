//https://www.youtube.com/watch?v=ZaVM057DuzE
package dp;

public class DP 
{
	public void change(int []a,int sum)
	{
		int []change = new int[sum+1];
		change[0] = 1;
		for(int i = 0;i < a.length;i++)
		{
			for(int j = a[i];j < change.length;j++)
			{
				if(j >= a[i])
				{
					change[j] += change[j - a[i]];
				}
			}
		}
		System.out.println("Ways:" + change[sum]);
	}
}
