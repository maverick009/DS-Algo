//Why passing a class object is pass by reference in java
package main;

class Node
{
	int row, col;
	public Node(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
}

public class Main 
{	
	public static void print(int [][]grid)
	{
		for(int i = 0;i < grid.length;i++)
		{
			for(int j = 0;j < grid.length;j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isassigned(int [][]grid, Node temp)
	{
		for(temp.row = 0;temp.row < grid.length;temp.row++)
			for(temp.col = 0;temp.col < grid.length;temp.col++)
				if(grid[temp.row][temp.col] == 0)
					return true;
		return false;
	}
	
	public static boolean usedinrow(int [][]grid, int row, int num)
	{
		for(int i = 0;i < grid.length;i++)
			if(grid[row][i] == num)
				return true;
		return false;
	}
	
	public static boolean usedincol(int [][]grid, int col, int num)
	{
		for(int i = 0;i < grid.length;i++)
			if(grid[i][col] == num)
				return true;
		return false;
	}
	
	public static boolean usedingrid(int [][]grid, int row, int col, int num)
	{
		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++)
				if(grid[row + i][col + j] == num)
					return true;
		return false;
	}
	
	public static boolean isSafe(int [][]grid, int row, int col, int num)
	{	
		return (!usedinrow(grid, row, num) && !usedincol(grid, col, num) && 
				!usedingrid(grid, (row - row % 3), (col - col % 3), num));
	}
	
	public static boolean solveSudoku(int [][]grid)
	{
		Node temp = new Node(0, 0);
		if(!isassigned(grid, temp))
			return true;
		for(int num = 1;num <= 9;num++)
		{
			//System.out.println("row:" + temp.row + "\tcol:" + temp.col + "\tnum:" + num);
			if(isSafe(grid, temp.row, temp.col, num))
			{
				grid[temp.row][temp.col] = num;
				//print(grid);
				if(solveSudoku(grid))
					return true;
				grid[temp.row][temp.col] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                		{5, 2, 0, 0, 0, 0, 0, 0, 0},
                		{0, 8, 7, 0, 0, 0, 0, 3, 1},
                		{0, 0, 3, 0, 1, 0, 0, 8, 0},
                		{9, 0, 0, 8, 6, 3, 0, 0, 5},
                		{0, 5, 0, 0, 9, 0, 6, 0, 0},
                		{1, 3, 0, 0, 0, 0, 2, 5, 0},
                		{0, 0, 0, 0, 0, 0, 0, 7, 4},
                		{0, 0, 5, 2, 0, 6, 3, 0, 0}
                	   };
		if(solveSudoku(grid))
			print(grid);
		else
			System.out.println("No Solution");
	}
}
