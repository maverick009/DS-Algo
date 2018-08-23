package main;
import dp.DP;

public class Main 
{
	public static void main(String[] args) 
	{
		int numegg = 2,floor = 36;
		DP d = new DP();
		System.out.println("Ways:" + d.eggdrop(floor, numegg));
	}	
}
