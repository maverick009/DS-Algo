package main;
import java.util.Scanner;

public class Main
{	
	public static int getmin(int []arr) {
		
		if(arr.length == 0)
			return -1;
		
		int sum = 0;
		for(int i = 0;i < arr.length;i++)
			sum += arr[i];
		
		int mean = (sum / arr.length);
		int counter = 0, minex = 0;
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] < mean) {
				counter += mean - arr[i];
				minex += mean - arr[i];
			}
			else 
				counter -= arr[i] - mean;
		}
		if(counter == 0)
			return minex;
		
		return -1;
	}
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int numpackets = sc.nextInt();
			if(numpackets == -1) {
				System.out.println();
				break;
			}
			
			int []arr = new int[numpackets];
			for(int i = 0;i < numpackets;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(getmin(arr));
		}	
	}
}