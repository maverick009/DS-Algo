package main;
import dp.DP;
public class Main 
{
	public static void main(String[] args) 
	{
		 int cost[][]= {{1, 2, 3},
                 		{4, 8, 2},
                 		{1, 5, 3}};
		 DP d = new DP();
		 System.out.println("Min Cost (0,0) to (2,2):" + d.cost(cost, 2, 2));
	}

}
