/*
 * Lily has a chocolate bar consisting of a row of n squares where each square has an integer written on it. 
 * She wants to share it with Ron for his birthday, which falls on month m and day d. 
 * Lily wants to give Ron a piece of chocolate only if it contains  consecutive squares whose integers sum to .
 * 
 *
 * Given m, d, and the sequence of integers written on each square of Lily's chocolate bar, 
 * how many different ways can Lily break off a piece of chocolate to give to Ron?

 * For example, if m = 2,d = 3  and the chocolate bar contains  rows of squares with the integers [1,2,1,3,2]
 * written on them from left to right, 
 * 
 * The first line contains an integer denoting n (the number of squares in the chocolate bar). 
 * The second line contains n space-separated integers describing the respective values of s0, ...., sn-1 
 * (the numbers written on each consecutive square of chocolate). 
 * The third line contains two space-separated integers describing the 
 * respective values of d (Ron's birth day) and m (Ron's birth month).
 * 
 * Print an integer denoting the total number of ways that Lily can give a piece of chocolate to Ron.
 * 
 * 5
 * 1 2 1 3 2 
 * 3 2
 * 
 * 2
*/


package main;
import java.util.Scanner;

public class Main 
{
	public static int getNumberOfWays(int n, int d, int m, int[] sum) {
        // Modify array to make each 'i' contain the running sum of prior elements
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }
        
        // Set number of ways counter
        // If there are >= 'm' squares AND the first possible piece has sum = 'd', 1
        // Else, 0
        int numberOfWays = (m <= n && sum[m - 1] == d) ? 1 : 0;
        
        // Check the sums for pieces ending at index 'm' through 'n - 1'
        for (int i = m; i < n; i++) {
            // If the sum of the piece is equal to 'd'
            if (sum[i] - sum[i - m] == d) {
                // Increment ways counter
                numberOfWays++;
            }
        }
        
        return numberOfWays;
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] squares = new int[n];
        for(int squares_i=0; squares_i < n; squares_i++){
            squares[squares_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        in.close();

        System.out.println(getNumberOfWays(n, d, m, squares));
    }
}
