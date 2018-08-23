import java.util.Scanner;

public class Main 
{
	/**
	 * @param args
	 */
	static int search(int []array,int num)
	{
		if(num == 0 || num < 0)
			return -1;
		
		for(int i = 0;i < array.length;i++)
		{
			if(array[i] == num)
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int [] array = new int[10];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<array.length;i++)
			array[i] = sc.nextInt();
		
		for(int i = 0;i<array.length;i++)
			System.out.println("element:" + array[i]);
		
		System.out.println("Enter an element to search:");
		int num = sc.nextInt();
		
		System.out.println("index:" + search(array,num));
		sc.close();
	}
}
