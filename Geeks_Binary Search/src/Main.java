import java.util.Scanner;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = sc.nextInt();
		int [] array = new int[size];
		
		for(int i = 0; i < size; i++)
			array[i] = sc.nextInt();
		
		System.out.println("Enter search element:");
		int num = sc.nextInt();
		
		System.out.println("index:" + binarySearch(array,num,0,array.length-1));
		
		sc.close();
	}
	
	static int binarySearch(int [] array,int num, int low, int high)
	{
		if(num <=0)
			return -1;
		
		while(low < high)
		{
			int mid = low + (high-low)/2;
			if(num == array[mid])
				return mid;
			else if(num > array[mid])
				low = mid + 1;
			else
				high = mid;
		}
		return -1;
	}

}
