package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import greedy.JobSchedule.Job;

public class JobSchedule 
{
	public class Job
	{
		int id;
		int deadline, profit;
		
		public Job(int id, int deadline, int profit)
		{
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	public int max_deadline(Job []list)
	{
		int max = Integer.MIN_VALUE;
		for(Job job : list)
			max = Math.max(max, job.deadline);
		return max;
	}
	
	public int find(int []parent, int i)
	{
		if(parent[i] != i)
			parent[i] = find(parent, parent[i]);
		return parent[i];
	}
	
	public void union(int []parent, int x, int y)
	{
		parent[y] = x;
	}
	
	public void schedule(int [][]arr)
	{
		Job []list = new Job[arr.length];
		for(int i = 0;i < arr.length;i++)
			list[i] = new Job(arr[i][0], arr[i][1], arr[i][2]);
		
		Comparator<Job> comp = new Comparator<JobSchedule.Job>() 
		{		
			@Override
			public int compare(Job o1, Job o2) 
			{
				return o2.profit - o1.profit;
			}
		};
		Arrays.sort(list, comp);
		/*for(int i = 0;i < list.length;i++)
			System.out.println((list[i].id - 'a')+ "\t" + list[i].deadline + "\t" + list[i].profit);*/
		int []parent = new int[max_deadline(list) + 1];
		for(int i = 0;i < parent.length;i++)
			parent[i] = i;
		
		System.out.println("Jobs for Maximum Profit");
		for(Job job : list)
		{
			int available_slot = find(parent, job.deadline);
			if(available_slot > 0)
			{
				union(parent, find(parent, available_slot - 1), available_slot);
				System.out.println((char)job.id+ "\t" + job.deadline + "\t" + job.profit);
			}
		}
	}
}