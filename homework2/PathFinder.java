package homework2;

import java.util.*;

/**
 * <b>Abstract Function-</b> path finder for a specific graph. holds the graph,
 * possible start points, possible end points. <b>Representation Invariant-</b>
 * this.graph != null && this.start_points != null && this.end_points != null
 */

public class PathFinder<N, P extends Path<N, P>> {
	private Graph<N> graph;
	private ArrayList<P> start_points;
	private ArrayList<P> end_points;
  	private void checkRep () {
  		assert 
  		this.graph != null && this.start_points != null && this.end_points != null:
  					"Rep. Inv. of class PathFinder is violated.";
  	}
	/**
	 * @requires graph != null && start_points != null && end_points != null
	 * @effects builds a instance of PathFinder with specific graph, start_points
	 *          and end_points
	 */
	public PathFinder(Graph<N> graph, ArrayList<P> start_points, ArrayList<P> end_points) {
		this.graph = graph;
		this.start_points = start_points;
		this.end_points = end_points;
		this.checkRep();
	}

	/**
	 * @requires nothing
	 * @effects returns the shortest path possible with the curretn graph, end
	 *          points, and start points
	 */
	public P FindShortestPath() {
		this.checkRep();
		// creating the data structures needed for the algorithmm
		HashMap<N, P> paths = new HashMap<>();
		for (P path : this.start_points) {
			paths.put(path.getEnd(), path);
		}
		PriorityQueue<P> active = new PriorityQueue<>(this.start_points);
		ArrayList<N> finished = new ArrayList<>();
		while (!active.isEmpty()) {

			// queueMin is the element of active with shortest path
			N queueMin = active.poll().getEnd();
			P queueMinPath = paths.get(queueMin);
			if (this.end_points.contains(queueMinPath)) {
				this.checkRep();
				return queueMinPath;
			}
			// iterate over edges (queueMin, c) in queueMin.edges
			for (N child : this.graph.getChildren(queueMin)) {
				P cpath = queueMinPath.extend(child);
				if (!finished.contains(child) && !active.contains(child)) {
					paths.put(child, cpath);
					// insert c in active with priority equal to cpath's cost;
					active.add(cpath);
				}
			}
			finished.add(queueMin);
		}
		// execution reaches this point only if active becomes empty
		this.checkRep();
		return null;
	}

}
