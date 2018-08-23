package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity
{
	int start, finish;
	public Activity(int start, int finish)
	{
		this.start = start;
		this.finish = finish;
	}
}

public class Main
{	
	public static void maxActivity(ArrayList<Activity> list)
	{
		Collections.sort(list, new Comparator<Activity>() 
		{
			public int compare(Activity a, Activity b)
			{
				return a.finish - b.finish;
			}
		});
		
		System.out.println("Start:" + list.get(0).start + "\tFinish:" + list.get(0).finish);
		int index = 0;
		for(int i = 1;i < list.size();i++)
		{
			if(list.get(i).start >= list.get(index).finish)
			{
				System.out.println("Start:" + list.get(i).start + "\tFinish:" + list.get(i).finish);
				index = i;
			}
		}
	}
	
	public static void main(String[] args) 
    {
	    ArrayList<Activity> arr = new ArrayList<>();
	    arr.add(new Activity(5, 9));
	    arr.add(new Activity(1, 2));
	    arr.add(new Activity(3, 4));
	    arr.add(new Activity(0, 6));
	    arr.add(new Activity(5, 7));
	    arr.add(new Activity(8, 9));
	    maxActivity(arr);
    }
}