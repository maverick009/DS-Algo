/*https://www.youtube.com/watch?v=CWDQJGaN1gY
 * https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/
 * 
 * Best One
 * https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition
 * -behind-a-binary-indexed-tree-and-how-was-it-thought-a
 * 
 * http://zobayer.blogspot.in/2013/11/various-usage-of-bit.html
 */

package bit;

public class BIT 
{
	int []bit;
	public void construct(int []arr)
	{
		bit = new int[arr.length + 1];
		for(int i = 0;i < arr.length;i++)
			update(arr, i,arr[i]);			
	}
	
	public void update(int []arr,int index,int val)
	{
		index = index + 1;
		while(index <= arr.length)
		{
			bit[index] += val;
			index += index & (-index);
		}
	}
	
	public int getSum(int index)
	{
		int sum = 0;
		index += 1;
		while(index > 0)
		{
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}
}