// https://www.geeksforgeeks.org/closest-pair-of-points-onlogn-implementation/
package main;

import java.util.Arrays;
import java.util.Comparator;

class Pair
{
	class Point {
		int x, y;
	}
	
	public double dist(Point p1, Point p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
	
	public double min(double a, double b) {
		return (a <= b)?a:b;
	}
	
	public double bruteforce(Point []p)
	{
		double min = Integer.MAX_VALUE;
		for(int i = 0;i < p.length;i++)
		{
			for(int j = i + 1;j < p.length;j++)
				if(dist(p[i], p[j]) < min)
					min = dist(p[i], p[j]);
		}
		return min;
	}
	
	public double stripclosest(Point []strip, int size, double d)
	{
		double min = d;
		for(int i = 0;i < size;i++)
		{
			for(int j = i + 1;j < size && (strip[j].y - strip[i].y) < min;j++)
				if(dist(strip[i], strip[j]) < min)
					min = dist(strip[i], strip[j]);
		}
		return min;
	}
	
	public double closestUtil(Point []Px, Point []Py, int n)
	{
		if(n <= 3)
			return bruteforce(Px);
		
		int mid = n / 2;
		Point midpoint = Px[mid];
		
		Point []Py1 = new Point[mid +1];
		Point []Py2 = new Point[n - mid - 1];
		
		int l = 0, r = 0;
		for(int i = 0;i < n;i++)
		{
			if(Py[i].x <= midpoint.x)
				Py1[l++] = Py[i];
			else
				Py2[r++] = Py[i];
		}
		
		double dl = closestUtil(Px, Py1, mid);
		double dr = closestUtil(Py1, Py2, n - mid);
		
		double d = min(dl, dr);
		
		Point []strip = new Point[n];
		int j = 0;
		
		for(int i = 0;i < n;i++) {
			if(Math.abs(Py[i].x - midpoint.x) < d) {
				strip[j].x = Py[i].x;
				strip[j].y = Py[i].y;				
				j++;
			}
		}	
		return min(d, stripclosest(strip, j, d));
	}
	
	public double closest(int [][]points)
	{
		Point []Px = new Point[points.length];
		Point []Py = new Point[points.length];
		
		for(int i = 0;i < points.length;i++)
		{
			Px[i].x = points[i][0];
			Px[i].y = points[i][1];
			
			Py[i].x = points[i][0];
			Py[i].y = points[i][1];
 		}
		
		Arrays.sort(Px, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		});
		
		Arrays.sort(Py, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});
		return closestUtil(Px, Py, points.length);
	}	
}

public class Main 
{
	public static void main(String[] args) 
	{
		int P[][] = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
		Pair p = new Pair();
		//System.out.println("The Smallest Distance is:" + p.closest(P));
	}
}