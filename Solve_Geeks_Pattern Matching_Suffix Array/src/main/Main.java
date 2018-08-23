package main;

import suffixarray.SuffixArray;

public class Main 
{
	public static void main(String[] args) 
	{
		SuffixArray sa = new SuffixArray();
		String text = "banana";
		//sa.build(text, text.length());
		String pat = "nan";
		sa.search(pat, text);
	}
}
