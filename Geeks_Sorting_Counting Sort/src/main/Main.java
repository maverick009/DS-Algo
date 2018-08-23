/*
 * https://www.youtube.com/watch?v=5rLrRpcBCzo
 * You have already coded for sort for range m to n.
 * count array = n - m + 1;
 * replace 'a' by m
*/
package main;

public class Main 
{
	public static void sort(String str)
	{
		if(str.length() == 0)
			return;
		
		char []arr = str.toCharArray();
		int []count = new int[26];
		for(int i = 0;i < arr.length;i++)
			++count[arr[i] - 'a'];
		
		for(int i = 1;i < count.length;i++)
			count[i] += count[i - 1];
		
		char []res = new char[arr.length];
		                      
		for(int i = arr.length - 1;i >= 0;i--)
		{
			res[count[arr[i] - 'a'] - 1] = arr[i];
			count[arr[i] - 'a']--;
		}
		
		for(char ch : res)
			System.out.print(ch + " ");
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		String str = "geeksforgeeks";
		System.out.println("Original String:" + str);
		System.out.println("Sorted String");
		sort(str);
	}
}