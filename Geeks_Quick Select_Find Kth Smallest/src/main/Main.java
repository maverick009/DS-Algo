package main;
import java.util.*;
import quickselect.QuickSelect;
import quickselect.QuickSelectRandom;

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[] = {12, 3, 5, 7, 4, 19, 26};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter K:");
		int k = sc.nextInt();
		//QuickSelect qs = new QuickSelect();
		QuickSelectRandom qs = new QuickSelectRandom();
		System.out.println(k + "th smallest element:" + qs.kthsmallest(arr, 0, arr.length - 1, k));
		sc.close();
	}
}
