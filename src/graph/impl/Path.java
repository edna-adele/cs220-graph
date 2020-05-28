package graph.impl;

public class Path implements Comparable<Path>{
	private String n;
	private int c;
	
	public Path(String name, int cost) {
		n = name;
		c = cost;
	}
	
	public int compareTo(Path p) {
		return c - p.c;
	}
	
	public int cost() {
		return c;
	}

}
