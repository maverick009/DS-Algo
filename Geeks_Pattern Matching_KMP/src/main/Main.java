package main;

public class Main 
{
	public static void lps(String pat, int []lps)
	{
		int i = 0, j = 1;
		lps[0] = 0;
		while(j < pat.length())
		{
			if(pat.charAt(i) == pat.charAt(j))
			{
				i++;
				lps[j] = i;
				j++;
			}
			else
			{
				if(i != 0)
					i = lps[i - 1];
				else
				{
					lps[j] = i;
					j++;
				}
			}			
		}
		
	}
	
	public static void kmp(String txt, String pat)
	{
		int []lps = new int[pat.length()];
		int j = 0;
		lps(pat, lps);
		
		int i = 0;
		
		while(i < txt.length())
		{
			if(pat.charAt(j) == txt.charAt(i))
			{
				i++;j++;
			}
			
			if(j == pat.length())
			{
				System.out.println("Found Pattern at Index:" + (i - j));
				j = lps[j - 1];
			}
			else if(i < txt.length() && pat.charAt(j) != txt.charAt(i))
			{
				if(j != 0)
					j = lps[j - 1];
				else
					i++;
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp(txt, pat);
	}
}
