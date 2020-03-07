package graphanalyzer.model.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a directed graph in form of a adjacency list.
 * 
 * @author paulehler
 *
 */
public class DirectedGraph implements Graph {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6752285074147903423L;
	
	private Map<Vertex, LinkedList<Vertex>> graph;

	private Set<Vertex> vertices;

	private Set<DirectedEdge> edges;

	/**
	 * Creates instance of a DirectedGraph.
	 */
	public DirectedGraph() {
		this.graph = new HashMap<>();
		this.vertices = new HashSet<>();
		this.edges = new HashSet<>();
	}
	
	/**
	 * Constructor to initialize a DirectedGraph with a given adjacency list and 
	 * 
	 * @param g  adjacency list that represents a graph
	 * @param v  set of vertices of given graph
	 * @param e  set of edges of given graph
	 */
	public DirectedGraph(Map<Vertex, LinkedList<Vertex>> g, Set<Vertex> v, Set<DirectedEdge> e) {
		graph = new HashMap<>(g);
		vertices = new HashSet<>(v);
		edges = new HashSet<>(e);
	}

	/**
	 * Adds edge with given vertices to the adjacency list {@link #graph}.
	 * 
	 * @param source source vertex of edge
	 * @param target target vertex of edge
	 */
	public void addEdge(Vertex source, Vertex target) {
		this.vertices.add(target);
		if (this.graph.get(source) == null) {
			addVertex(source);
		} else if (this.graph.get(source).contains(target)) {
			return;
		}
		this.graph.get(source).add(target);
		edges.add(new DirectedEdge(source, target, true));
	}

	/**
	 * Adds vertex to the adjacency list.
	 * 
	 * @param vertex source {@link Vertex}
	 */
	public void addVertex(Vertex vertex) {
		this.graph.put(vertex, new LinkedList<Vertex>());
		this.vertices.add(vertex);
	}
	
	@Override
	public Set<Vertex> getVertices() {
		return vertices;
	}

	@Override
	public Set<DirectedEdge> getEdges() {
		return edges;
	}


	/**
	 * Returns all successor vertices of the given vertex.
	 * 
	 * @param vertex 
	 * @return all successor vertices of the given vertex
	 */
	public Set<Vertex> getTargetsOfVertex(Vertex vertex) {
		Set<Vertex> targets = new HashSet<>();
		if (graph.get(vertex) != null) {
			graph.get(vertex).stream().forEach(v -> targets.add(v));
		}
		return targets;
	}
	
	public Map<Vertex, LinkedList<Vertex>> getGraphAsAdjajencyList() {
		return this.graph;
	}
	
	/**
	 * Returns the transpose of this graph.
	 * 
	 * @return  the transposed version of the graph
	 */
	public DirectedGraph getTransposedGraph() {
		Map<Vertex, LinkedList<Vertex>> transposedGraph = new HashMap<>();
		
		for (Map.Entry<Vertex, LinkedList<Vertex>> entry : graph.entrySet()) {
			Vertex newDstVertex = entry.getKey();
			LinkedList<Vertex> adjacentVertices = entry.getValue();
			if (adjacentVertices != null) {
				for (Vertex newSrcVertex : adjacentVertices) {
					if (newSrcVertex == null) {
						continue;
					} else if(!transposedGraph.containsKey(newSrcVertex)) {
						transposedGraph.put(newSrcVertex, new LinkedList<Vertex>());
					} 
					transposedGraph.get(newSrcVertex).add(newDstVertex);
				}
			}
		}
		return new DirectedGraph(transposedGraph, vertices, edges);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Vertex, LinkedList<Vertex>> entry : graph.entrySet()) {
			String src;
			String dst;
			src = (entry.getKey() != null) ? entry.getKey().toString() : "";
			dst = (entry.getValue() != null) ? entry.getValue().toString() : ""; 
			
			builder.append(src + "->" + dst +"\n");
			
		}
		return builder.toString();
	}

}
