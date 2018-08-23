package main;

import trie.Trie;

public class Main 
{
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		String []ipadd= {"107.108.11.123", "107.109.123.255","74.125.200.106"};
		String []url = {"www.samsung.com", "www.samsung.net","www.google.in"};
		for(int i = 0;i < ipadd.length;i++)
			trie.insert(ipadd[i], url[i]);
		for(int i = 0;i < ipadd.length;i++)
			System.out.println(trie.search(ipadd[i]));
	}
}
