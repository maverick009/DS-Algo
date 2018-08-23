package main;
import java.util.*;

public class Main
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
        String s = in.next();
        /*String result = super_reduced_string(s);
        if(result != null)
        	System.out.println(result);
        else
        	System.out.println("Empty String");*/
        
        while(true)
        {
        	int len = s.length();
        	s = s.replaceAll("(.)\\1", "");
        	
        	if(s.length() == len)
        		break;
        }
        System.out.println((s.isEmpty())? "Empty String" : s);
        in.close();
        
	}
	
	/*public static String super_reduced_string(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		boolean red = true;
		while(red == true)
		{
			for(int i = 1;i < sb.length();i++)
				if(sb.charAt(i) == sb.charAt(i - 1))
					sb.replace(i - 1, i + 1, "");
			
			red = false;
			for(int i = 1;i < sb.length();i++)
				if(sb.charAt(i) == sb.charAt(i - 1))
					red = true;
		}
		return (sb.length() != 0)?sb.toString():null;
    }*/
}
