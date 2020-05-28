package graph.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import graph.IGraph;
import graph.INode;
import graph.NodeVisitor;

/**
 * A basic representation of a graph that can perform BFS, DFS, Dijkstra,
 * and Prim-Jarnik's algorithm for a minimum spanning tree.
 * 
 * @author jspacco
 *
 */
public class Graph implements IGraph
{
	Map<String, INode> graph = new HashMap<>();
    
    /**
     * Return the {@link Node} with the given name.
     * 
     * If no {@link Node} with the given name exists, create
     * a new node with the given name and return it. Subsequent
     * calls to this method with the same name should
     * then return the node just created.
     * 
     * @param name
     * @return
     */
    public INode getOrCreateNode(String name) {
        //throw new UnsupportedOperationException("Implement this method");
        if(graph.containsKey(name))
        	return graph.get(name);
        
        INode node = new Node(name);
        graph.put(name, node);
        return node;
    }

    /**
     * Return true if the graph contains a node with the given name,
     * and false otherwise.
     * 
     * @param name
     * @return
     */
    public boolean containsNode(String name) {
        //throw new UnsupportedOperationException("Implement this method");
    	if(graph.containsKey(name))
    		return true;
    	return false;
    }

    /**
     * Return a collection of all of the nodes in the graph.
     * 
     * @return
     */
    public Collection<INode> getAllNodes() {
        //throw new UnsupportedOperationException("Implement this method");
    	return graph.values();   
    }
    
    /**
     * Perform a breadth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     * 
     * 
     * @param startNodeName
     * @param v
     */
    public void breadthFirstSearch(String startNodeName, NodeVisitor v)
    {
        // TODO: Implement this method
        //throw new UnsupportedOperationException("Implement this method");
    	Set<INode> visited = new HashSet<INode>();
    	Queue<INode> t = new LinkedList<INode>();
    	
    	t.add(graph.get(startNodeName));
    	
    	while(!t.isEmpty()) {
    		INode n = t.poll();
    		if(visited.contains(n))
    			continue;
    		v.visit(n);
    		visited.add(n);
    		
    		ArrayList<INode> neighbors = new ArrayList<INode>();
    		neighbors.addAll(n.getNeighbors());
    		
    		for(int i=0; i<neighbors.size(); i++) 
    			if(!visited.contains(neighbors.get(i)))
    				t.add(neighbors.get(i));	
    	}
    }

    /**
     * Perform a depth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     * 
     * 
     * @param startNodeName
     * @param v
     */
    public void depthFirstSearch(String startNodeName, NodeVisitor v)
    {
        // TODO: implement this method
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Perform Dijkstra's algorithm for computing the cost of the shortest path
     * to every node in the graph starting at the node with the given name.
     * Return a mapping from every node in the graph to the total minimum cost of reaching
     * that node from the given start node.
     * 
     * <b>Hint:</b> Creating a helper class called Path, which stores a destination
     * (String) and a cost (Integer), and making it implement Comparable, can be
     * helpful. Well, either than or repeated linear scans.
     * 
     * @param startName
     * @return
     */
    public Map<INode,Integer> dijkstra(String startName) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Implement this method");
    }
    
    /**
     * Perform Prim-Jarnik's algorithm to compute a Minimum Spanning Tree (MST).
     * 
     * The MST is itself a graph containing the same nodes and a subset of the edges 
     * from the original graph.
     * 
     * @return
     */
    public IGraph primJarnik() {
        //TODO Implement this method
        throw new UnsupportedOperationException();
    }
}