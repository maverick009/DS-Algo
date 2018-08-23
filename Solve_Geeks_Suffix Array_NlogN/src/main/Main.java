package main;
import suffixarray.SuffixArray;

public class Main 
{
	public static void main(String[] args) 
	{
		String text = "banana";
		SuffixArray sa = new SuffixArray();
		sa.suffixArray(text);
		sa.print(sa.suffixArray);
	}
}
