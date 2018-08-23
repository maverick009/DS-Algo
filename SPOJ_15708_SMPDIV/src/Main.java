import java.util.Scanner;

public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if(input <= 0)
			sc.close();
		
		for(int i =0;i < input;i++)
		{
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(n<=0 || x <=0 || y<=0)
				sc.close();
			
			for(int j = x; j < n ; j +=x)
			{
				if((j % y)!= 0)
					System.out.print(j + " ");
			}
			System.out.print("\n");
		}		
		sc.close();
	}
}
