package main;

import java.util.Scanner;

public class Main {

	public static int multiply(int []res, int size, int x) {
		
		int carry = 0;
		for(int i = 0;i < size;i++) {
			
			int prod = res[i] * x + carry;
			res[i] = prod % 10;
			carry = prod / 10;
		}
		while(carry != 0) {
			res[size] = carry % 10;
			carry /= 10;
			size++;
		}
		return size;
	}
	
	public static void factorial(int num) {
		
		int []res = new int[160];
		int size = 1;
		res[0] = 1;
		
		for(int i = 2;i <= num;i++) {
			size = multiply(res, size, i);
		}
		for(int i = size -1;i >=0;i--)
			System.out.print(res[i]);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0;i < N;i++) {
			int num = sc.nextInt();
			factorial(num);
		}
	}
}
