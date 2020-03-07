package graphanalyzer.model.graph;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author paulehler
 *
 */
public interface Graph extends Serializable {
	
	/**
	 * Adds edge to graph with given source and target vertex.
	 * 
	 * @param source
	 * @param target
	 */
	public void addEdge(Vertex source, Vertex target);
	
	/**
	 * Adds vertex to graph.
	 * 
	 * @param vertex
	 */
	public void addVertex(Vertex vertex);
	
	/**
	 * Returns a set of the edges defined in the graph.
	 * 
	 * @return  all edges of graph
	 */
	public Set<DirectedEdge> getEdges();
	
	/**
	 * Returns a set of vertices defined in the graph.
	 * 
	 * @return  all vertices of graph
	 */
	public Set<Vertex> getVertices();
	

}
