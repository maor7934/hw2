package homework2;

import java.util.*;

class AlreadyHasNodeException extends Exception {

}

class AlreadyHasEdgeException extends Exception {

}

class NodeNotInGraphExpection extends Exception {

}

public class Graph<T> {

	/**
	 * <b>Abstract Function-</b> The class contains all the nodes of certain graph,
	 * with it's connectivity (edges) between nodes. <b>Representation
	 * Invariant-</b> all the edges must be contained inside the graph. no null
	 * nodes.
	 */
	private void checkRep() {
		assert this.nodeCollection != null : "Rep. Inv. of class is violeted";
	}

	protected HashMap<T, HashSet<T>> nodeCollection;

	// TODO: maybe for checkrep?
	private Boolean checkAllSetInGraph(HashSet<T> childrenSet) {

		Iterator<T> iChild = childrenSet.iterator();
		while (iChild.hasNext()) {
			T currChild = iChild.next();
			if (!this.nodeCollection.containsKey(currChild)) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Constructs new graph object.
	 * 
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
	 * 
	 * @requires the valid String node Name, and a node with type <T>.
	 * @effects Adds the node into the graph (adds new object).
	 * @modifies this object.
	 * @throws expection if Node already exists
	 **/
	public void addNode(T new_node) throws AlreadyHasNodeException {
		checkRep();
		if (this.nodeCollection.containsKey(new_node)) {
			throw new AlreadyHasNodeException();

		}
		this.nodeCollection.putIfAbsent(new_node, new HashSet<T>());
		checkRep();
	}

	/**
	 * Adds a new edge between parent and child nodes.
	 * 
	 * @requires none
	 * @effects Adds the edge into the graph (adds new object).
	 * @modifies this object.
	 * @return true if added the child,
	 * @throws expection is it didn't (parent or child arn't found in the graph)
	 **/
	public Boolean addEdge(T parent_node, T child_node_name) throws AlreadyHasEdgeException, NodeNotInGraphExpection {
		checkRep();
		if (!(this.nodeCollection.containsKey(parent_node) && this.nodeCollection.containsKey(child_node_name))) {
			throw new NodeNotInGraphExpection();
		}
		if (this.nodeCollection.get(parent_node).contains(child_node_name)) {
			throw new AlreadyHasEdgeException();
		}
		return this.nodeCollection.get(parent_node).add(child_node_name);
	}

	/**
	 * the function returns a set of the keys in the graph.
	 * 
	 * @requires this object is initialized
	 * @effects none
	 * @modifies none
	 * @return set of the nodes in the graph.
	 **/
	public ArrayList<T> getNodes() {
		checkRep();
		return new ArrayList<T>(this.nodeCollection.keySet()); // TODO: maybe return hard copy of nodes?
	}

	/**
	 * the function returns an arraylist of the children of a given parent nod in
	 * the graph.
	 * 
	 * @requires this object is initialized
	 * @effects none
	 * @modifies none
	 * @return if the parent exist in the graph, we'll return an array list
	 *         containing its children, and null otherwise.
	 **/
	public ArrayList<T> getChildren(T parentNode) {
		checkRep();
		if (this.nodeCollection.containsKey(parentNode)) {
			// return this.nodeCollection.get(parentNode);
			return new ArrayList<T>(this.nodeCollection.get(parentNode)); // TODO: maybe return hard copy of nodes?
		}
		return null;
	}
}
