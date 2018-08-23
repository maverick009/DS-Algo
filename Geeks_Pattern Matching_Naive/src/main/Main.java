package main;

public class Main 
{
	public static void search(String text, String pat)
	{
		int N = text.length();
		int M = pat.length();
		
		for(int i = 0;i <= N - M;i++)
		{
			int j;
			for(j = 0;j < M;j++)
				if(text.charAt(i + j) != pat.charAt(j))
					break;
				
			if(j == pat.length())
				System.out.println("Pattern Found at Index:" + i);
		}
	}	
	
	public static void main(String[] args) 
	{
		String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
	}
}