package main;

import trie.Trie;

public class Main 
{
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		trie.insert("are");
		trie.insert("area");
		trie.insert("base");
		trie.insert("cat");
		trie.insert("cater");
		trie.insert("basement");
		System.out.println(trie.longestPrefix("caterer"));
		System.out.println(trie.longestPrefix("basement"));
		System.out.println(trie.longestPrefix("are"));
		System.out.println(trie.longestPrefix("arex"));
		System.out.println(trie.longestPrefix("basemexz"));
		System.out.println(trie.longestPrefix("xyz"));
	}
}
