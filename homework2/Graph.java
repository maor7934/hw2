package homework2;
import java.util.*;

public class Graph<T> {
	
	/**
	 * <b>Abstract Function-</b>
	 * 	The class contains all the nodes of certain graph, with it's connectivity (edges) between nodes.
	 * <b>Representation Invariant-</b>
	 * 		all the edges must be contained inside the graph.
	 * 		no null nodes.
	 */
	private void checkRep() {
		assert
			this.nodeCollection != null :
				"Rep. Inv. of class is violeted";
	}
	
	
	private HashMap<T, HashSet<T>> nodeCollection;
	
	//TODO: maybe for checkrep? 
	private Boolean checkAllSetInGraph(HashSet<T> childrenSet) {
		
	     Iterator<T> iChild = childrenSet.iterator();
	     while(iChild.hasNext()){
	        T currChild = iChild.next();
	        if (!this.nodeCollection.containsKey(currChild)){
	        	return false;
	        }     
	     }
	     return true;
		
	}

	
  	/**
  	 * Constructs new graph object.
     * @requires none.
   	 * @effects constructs an empty graph.
   	 * @modifies this object
   	 **/  	
	public Graph() {
		this.nodeCollection = new HashMap<T, HashSet<T>>();
		checkRep();
	}
	
  	/**
  	 * Adds a new Node to the graph.
     * @requires the valid String node Name, and a node with type <T>.
   	 * @effects Adds the node into the graph (adds new object).
   	 * @modifies this object.
   	 **/
	public void addNode(T newnode) {
		checkRep();
		this.nodeCollection.putIfAbsent(newnode, new HashSet<T>());
		checkRep();
	}
	
  	/**
  	 * Adds a new edge between parent and child nodes.
     * @requires none
   	 * @effects Adds the edge into the graph (adds new object).
   	 * @modifies this object.
   	 * @return true if added the child 
   	 **/// as
	public Boolean addEdge(T parentNode, T childNodeName) {
		checkRep();
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
		checkRep();
		return this.nodeCollection.keySet(); //TODO: maybe return hard copy of nodes?
	}
	
  	/**
  	 * the function returns a set of the children of a given parent nod in the graph.
     * @requires none
   	 * @effects none
   	 * @modifies none
   	 **/
	public ArrayList<T> getChildren(T parentNode){
		checkRep();
		if (this.nodeCollection.containsKey(parentNode)) {
			//return this.nodeCollection.get(parentNode);
			return new ArrayList<T>(this.nodeCollection.get(parentNode)); //TODO: maybe return hard copy of nodes?
		}
		return null; 
	}
}
