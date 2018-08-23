package backtrack;

public class Backtrack 
{
	public String swap(String str,int a,int b)
	{
		char []c = str.toCharArray();
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
		return String.valueOf(c);
	}
	
	public void permute(String str,int l,int h)
	{
		if(l == h)
			System.out.println(str);
		else
		{
			for(int i = l;i <= h;i++)
			{
				str = swap(str,l,i);
				permute(str,l+1,h);
				str = swap(str,l,i);
			}
		}
	}
}
