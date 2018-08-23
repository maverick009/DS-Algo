package suffixarray;
import java.util.Arrays;

public class SuffixArray 
{
	public class Suffix
	{
		int index;
		String suffix;
		
		public Suffix(int index, String suffix) {
			this.index = index;
			this.suffix = suffix;
		}
	}
	
	public void print(int []arr, Suffix []suffix)
	{
		System.out.println("Index" + "\t\tSuffix");
		for(int i = 0;i < arr.length;i++)
			System.out.println(arr[i] + "\t\t" + suffix[i].suffix);
	}
	
	public int[] build(String text, int N)
	{
		Suffix []suffix = new Suffix[N];
		for(int i = 0;i < suffix.length;i++)
			suffix[i] = new Suffix(i, text.substring(i));
		
		Arrays.sort(suffix, (a, b) -> a.suffix.compareTo(b.suffix));
		
		int []sa = new int[N];
		for(int i = 0;i < N;i++)
			sa[i] = suffix[i].index;
		//print(sa, suffix);
		return sa;
	}
	
	public void search(String pat, String txt)
	{
		int n = txt.length();
		int m = pat.length();
		int low = 0, high = n - 1;
		
		int []sa = build(txt, txt.length());
		for(int i = 0;i < sa.length;i++)
			System.out.println(sa[i] + "\t" + txt.substring(sa[i]));
		while(low <= high)
		{
			int res = 0;
			int mid = low + (high - low)/2;
			if(sa[mid] + m <= high)
				res = pat.compareTo(txt.substring(sa[mid], sa[mid] + m));
			else
				res = pat.compareTo(txt.substring(sa[mid]));
			
			if(res == 0) {
				System.out.println("Pattern Found:" + sa[mid]);
				return;
			}
			
			if(res < 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		System.out.println("Pattern Not Found");
	}
}