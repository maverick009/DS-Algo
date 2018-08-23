package ip;

public class IP 
{
	public boolean isValid(char num)
	{
		return (num <= 9 && num >= 0);
	}
	
	public boolean validate(String ip)
	{
		if(ip.length() == 0)
			return false;
		for(char ch : ip.toCharArray())
		{
			
		}
		
		return false;
	}
}
