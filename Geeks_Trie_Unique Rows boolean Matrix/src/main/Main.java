package main;

import trie.Trie;

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[][] = {{0, 1, 0, 0, 1}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 1}, {1, 0, 1, 0, 0} };
		
		Trie trie = new Trie();
		for(int i = 0;i < arr.length;i++)
			trie.insert(arr[i]);
	}
}
