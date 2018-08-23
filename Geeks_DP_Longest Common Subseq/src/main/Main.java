package main;
import dp.DP;

public class Main 
{
	public static void main(String[] args) 
	{	
		String a = /*"ABCDGH";*/"AGGTAB";
		String b = /*"AEDFHR";*/"GXTXAYB";
		/*Scanner sc = new Scanner(System.in);
		a = sc.next();
		b = sc.next();*/
		DP d = new DP();
		System.out.println("Common Subseq:" + d.subseq(a, b));
	}

}
