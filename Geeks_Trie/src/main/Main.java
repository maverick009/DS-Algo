package main;
import trie.*;

public class Main 
{
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
	    String keys[] = {"the", "a", "there", "answer", "any","by", "bye", "their"};
	    for(int i = 0;i < keys.length;i++)
	    	trie.insert(keys[i]);
	    System.out.println(trie.search("the"));
	    System.out.println("answer:" + trie.search("answer"));
	    System.out.println(trie.search("rakesh"));
	    trie.delete(trie.root, "answer");
	    trie.delete(trie.root, "their");
	    System.out.println("answer:" + trie.search("answer"));
	    System.out.println("the:" + trie.search("their"));
	    System.out.println("the:" + trie.search("the"));
	}
}
