package homework2;
import java.util.*;

/**
 * <b>Abstract Function-</b>
 *   path finder for a specific graph. holds the graph, possible start points,
 *    possible end points.
 * <b>Representation Invariant-</b>
 * this.graph != null && this.start_points != null && this.end_points != null
 */

public class PathFinder<N,P extends Path<N,P>> {
	private Graph<N> graph;
	//private ArrayList<P>
	
	
	/**
	 * @requires graph != null && start_points != null && end_points != null
	 * @effects builds a instance of PathFinder with  specific graph, start_points
	 *  and end_points
	 */
	public PathFinder(Graph<N> graph, ArrayList<P> start_points, ArrayList<P> end_points) {
	
	}
	/**
	 * @requires 
	 * @effects returns the shortest path possible with the curretn graph, end
	 * points, and start points
	 */
	public P FindShortestPath( ) {
		
	}
	

}
	
