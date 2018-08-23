package main;
//For Arrays of different Sizes
public class DiffSize 
{
	float m2(int a, int b)
	{
		return (a + b)/2;
	}
	
	float m3(int a, int b, int c)
	{
		return a + b + c - Integer.max(a, Integer.max(b, c)) - Integer.min(a, Integer.min(b, c));
	}
	
	

}
