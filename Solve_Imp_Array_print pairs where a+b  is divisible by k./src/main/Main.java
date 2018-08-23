/*
 * You are given an array of n integers and a positive integer k . 
 * Find and print the number of (i,j) pairs where (i < j) and  (ai+aj) is divisible by k.
 * Constraints
 * 2 <= n <= 100
 * 1 <= k <= 100
 * 1 <= ai <= 100 
 */

package main;
import java.util.Scanner;

public class Main 
{
	public static int divisibleSumPairs(int n, int k, int[] ar) 
	{
		int count = 0;
        for(int i = 0;i < ar.length;i++)
        {
        	for(int j = i + 1;j < ar.length;j++)
        	{
        		if(((ar[i] + ar[j]) % k) == 0)
        			count++;
        	}
        }
		return count;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++)
            ar[ar_i] = in.nextInt();
        
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}