package main;

public class Main 
{
	public static final int NUM = 256;
	
	public static void compute(String pat, int M, int [][]FA)
	{
		int i, lps = 0, x;
		for(x = 0;x < NUM;x++)
			FA[0][x] = 0;
		
		FA[0][pat.charAt(0)] = 1;
		
		for(i = 1;i <= M;i++)
		{
			for(x = 0;x < NUM;x++)
				FA[i][x] = FA[lps][x];
			
			if(i == M)
				break;
			
			FA[i][pat.charAt(i)] = i + 1;
			if(i < M)
				lps = FA[lps][pat.charAt(i)];
		}
	}
	
	public static void search(String pat, String txt)
	{
		int M = pat.length();
		int N = txt.length();
		
		int [][]FA = new int[M + 1][NUM];
		compute(pat, M, FA);
		
		int state = 0;
		for(int i = 0;i < N;i++)
		{
			state = FA[state][txt.charAt(i)];
			if(state == M)
				System.out.println("Pattern Found at index:" + (i - M + 1));
		}
	}
	
	public static void main(String[] args) 
	{
		String txt = "AABAACAADAABAAABAA";
	    String pat = "AABA";
	    search(pat, txt);
	}
}