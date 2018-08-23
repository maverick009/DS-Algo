package main;

import trie.Trie;

public class Main 
{
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		String []url = { "www.samsung.com", "www.samsung.net","www.google.in","google.in"};
		String []ip = { "107.108.11.123", "107.109.123.255","74.125.200.106","74.125.200.106"};
		for(int i = 0;i < url.length;i++)
			trie.insert(url[i], ip[i]);
		for(int i = 0;i < url.length;i++)
			System.out.println(trie.search(url[i]));
	}
}
