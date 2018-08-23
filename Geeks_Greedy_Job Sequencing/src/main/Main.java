package main;

import java.util.ArrayList;
import java.util.Collections;

import greedy.JobSchedule;
import main.Djikstra.Job;

class Djikstra
{
	public class Job implements Comparable<Job>
	{
		char id;
		int deadline;
		int profit;
		
		public Job(char id, int deadline, int profit)
		{
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
		@Override
		public int compareTo(Job j)
		{
			return j.profit - this.profit;
		}
	}
	
	public int min(int a, int b)
	{
		return (a < b)?a: b;
	}
	
	public void jobschedule(ArrayList<Job> jobs)
	{
		Collections.sort(jobs);
		int []result = new int [jobs.size()];
		boolean []slot = new boolean[jobs.size()];
		for(int i = 0;i < jobs.size();i++)
		{
			for(int j = min(jobs.size(), jobs.get(i).deadline) - 1; j >= 0;j--)
			{
				if(!slot[j])
				{
					slot[j] = true;
					result[j] = i;
					break;
				}
			}
		}
		System.out.println("JobID" + "\tDeadline" + "\tProfit");
		for(int i = 0;i < jobs.size();i++)
			if(slot[i])
				System.out.println(jobs.get(result[i]).id + "\t" + jobs.get(result[i]).deadline + "\t\t"
						+ jobs.get(result[i]).profit);
	}	
}

public class Main 
{
	public static void main(String[] args) 
	{
		/*Djikstra d = new Djikstra();
		ArrayList<Djikstra.Job> jobs = new ArrayList<>();
		jobs.add(d.new Job('a', 2, 100));
		jobs.add(d.new Job('b', 1, 19));
		jobs.add(d.new Job('c', 2, 27));
		jobs.add(d.new Job('d', 1, 25));
		jobs.add(d.new Job('e', 3, 15));*/
		
		//d.jobschedule(jobs);
		int [][]arr = { {'a', 2, 100}, {'b', 1, 19}, {'c', 2, 27}, {'d', 1, 25}, {'e', 3, 15}};
		JobSchedule js = new JobSchedule();
		js.schedule(arr);
		
	}
}