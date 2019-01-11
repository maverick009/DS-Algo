package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Item implements Comparator<Item>{
	
	int wt, val;
	Double cost;
	public Item(int wt, int val) {
		this.wt = wt;
		this.val = val;
		this.cost = new Double(val/wt);
	}
	
	@Override
	public int compare(Item o1, Item o2) {
		return o1.cost.compareTo(o2.cost);
	}	
}

public class Main {

	public static void main(String[] args) {
		int[] wt = {10, 40, 20, 30}; 
		int[] val = {60, 40, 100, 120}; 
	    int capacity = 50;
	    System.out.println(knapsack(wt, val, capacity));	    
	}
	
	static int knapsack(int []wt, int []val, int capacity) {
		
		int total = 0;
		Item []items = new Item[wt.length];
		for(int i = 0;i < wt.length;i++)
			items[i] = new Item(wt[i], val[i]);
		Arrays.sort(items , new Comparator<Item>() {
			@Override 
			public int compare(Item i1, Item i2) {
				return i2.cost.compareTo(i1.cost);
			}			
		});
		
		for(Item i : items) {
			int weight = i.wt;
			int value = i.val;
			
			if(capacity - weight >= 0) {
				capacity = capacity - weight;
				total += value;
			} else {
				double fraction = (double) capacity/weight;
				total += value * fraction;
				capacity -= weight * fraction;
				break;				
			}			
		}
		return total;
	}
}