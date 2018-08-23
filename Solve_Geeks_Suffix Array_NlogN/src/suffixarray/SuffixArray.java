package suffixarray;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray 
{
	public int []suffixArray;
	
	class Suffix
	{
		int index;
		int []rank = new int[2];
		
		public Suffix(int index, int rank0, int rank1)
		{
			this.index = index;
			this.rank[0] = rank0;
			this.rank[1] = rank1;
		}
	}
	
	public static Comparator<Suffix> comp = new Comparator<SuffixArray.Suffix>() 
	{		
		@Override
		public int compare(Suffix a, Suffix b) 
		{
			return (a.rank[0] == b.rank[0])?(a.rank[1] < b.rank[1]? 1:0):(a.rank[0] < b.rank[0]?1:0);
		}
	};
	
	public void suffixArray(String text)
	{
		Suffix []suffix = new Suffix[text.length()];
		
		for(int i = 0;i < text.length();i++)
			suffix[i] = new Suffix(i, (text.charAt(i) - 'a'), ((i + 1 < text.length())?text.charAt(i + 1) - 'a': -1));		
		
		Arrays.sort(suffix, comp);
		int []ind = new int[text.length()];
		
		for(int k = 4;k < 2 * text.length();k *= 2)
		{
			int rank = 0;
			int prev_rank = suffix[0].rank[0];
			suffix[0].rank[0] = rank;
			ind[suffix[0].index] = 0;
			
			for(int i = 1;i < text.length();i++)
			{
				if(suffix[i].rank[0] == prev_rank && suffix[i].rank[1] == suffix[i - 1].rank[1])
				{
					prev_rank = suffix[i].rank[0];
					suffix[i].rank[0] = rank;
				}
				else
				{
					prev_rank = suffix[i].rank[0];
					suffix[i].rank[0] = ++rank;
				}
				ind[suffix[i].index] = i;
			}
			
			for(int i = 0;i < text.length();i++)
			{
				int next_index = suffix[i].index + k/2;
				suffix[i].rank[1] = (next_index < text.length())?suffix[ind[next_index]].rank[0] : -1;
			}
			
			Arrays.sort(suffix, comp);
			for(Suffix node : suffix)
			{
				System.out.print("index:" + node.index + "\trank0:" + node.rank[0] + "\trank1:" + node.rank[1]);
				System.out.println();
			}
		}
		
		suffixArray = new int[text.length()];
		for(int i = 0;i < text.length();i++)
			suffixArray[i] = suffix[i].index;
	}
	
	public void print(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}