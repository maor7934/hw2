package homework2;
import java.util.*;

public class Graph<T> {
	private HashMap<T, HashSet<T>> nodeCollection;
	
  	/**
  	 * Constructs new graph object.
     * @requires the valid String graphName.
   	 * @effects constructs an empty graph.
   	 * @modifies this object
   	 **/
	public Graph() {
		this.nodeCollection = new HashMap<T, HashSet<T>>();
		
	}
	
  	/**
  	 * Adds a new Node to the graph.
     * @requires the valid String node Name, and a node with type <T>.
   	 * @effects Adds the node into the graph (adds new object).
   	 * @modifies this object.
   	 **/
	public void addNode(T newnode) {
		this.nodeCollection.putIfAbsent(newnode, new HashSet<T>());
	}
	
  	/**
  	 * Adds a new edge between parent and child nodes.
     * @requires none
   	 * @effects Adds the edge into the graph (adds new object).
   	 * @modifies this object.
   	 **/
	public Boolean addEdge(T parentNode, T childNodeName) {
		if (this.nodeCollection.containsKey(parentNode) && this.nodeCollection.containsKey(childNodeName)){
			return this.nodeCollection.get(parentNode).add(childNodeName);
		}
		return false;
		
	}
  	/**
  	 * the function returns a set of the keys in the graph.
     * @requires none
   	 * @effects none
   	 * @modifies none
   	 **/
	public Set<T> getNodes(){
		return this.nodeCollection.keySet(); //TODO: maybe return hard copy of nodes?
	}
	
  	/**
  	 * the function returns a set of the children of a given parent nod in the graph.
     * @requires none
   	 * @effects none
   	 * @modifies none
   	 **/
	public HashSet<T> getChildren(T parentNode){
		if (this.nodeCollection.containsKey(parentNode)) {
			return this.nodeCollection.get(parentNode); //TODO: maybe return hard copy of nodes?
		}
		return null; 
	}
	
	

	
	
	
	
	
	
}
