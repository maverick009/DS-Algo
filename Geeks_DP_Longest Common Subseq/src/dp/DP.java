package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DP 
{
	public int max(int a,int b)
	{
		return (a >= b?a:b);
	}
	
	public int subseq(String a,String b)
	{
		Set<Character> set = new HashSet<>();
		int [][]arr = new int[a.length()+1][b.length()+1];
		
		for(int i = 0;i <= a.length();i++)
		{
			for(int j = 0;j <= b.length();j++)
			{
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				else if(a.charAt(i-1) == b.charAt(j-1))
				{
					arr[i][j] = arr[i-1][j-1] + 1;
					set.add(a.charAt(i-1));
				}
				else
					arr[i][j] = max(arr[i-1][j],arr[i][j-1]);
			}
		}
		System.out.print("Subsequence:");
		for(char s : set)
			System.out.print(s + " ");
		System.out.println();
		return arr[a.length()][b.length()];
	}
}
