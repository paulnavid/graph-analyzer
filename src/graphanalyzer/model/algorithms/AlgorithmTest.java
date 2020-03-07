package graphanalyzer.model.algorithms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import graphanalyzer.model.graph.*;

/**
 * Implementation of a graph algorithm that calculates strongly connected components based on two depth-first-searches.
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Strongly_connected_component">Strongly connected component (Wikipedia)</a>
 * 
 * @deprecated
 * 
 * @author Paul Ehler
 *
 */
@Deprecated(forRemoval=true)
public class AlgorithmTest implements Algorithm, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3049007391864642836L;

	//
	private DirectedGraph graph;

	//
	private DirectedGraph transposedGraph;

	//
	private List<ArrayList<Vertex>> stronglyConnectedComponents;

	private Set<Vertex> visitedVertices;

	private Stack<Vertex> finishedVertices;
	
	private LinkedList<Vertex> firstDFS;
	private LinkedList<Vertex> secondDFS;
	
	// 
	private int time;
	//
	private Map<Vertex, Integer> discoveryTimes;
	private Map<Vertex, Integer> finishingTimes;
    
    private Vertex currentVertex;
    private boolean isSecondDfs;

	/**
	 * 
	 * @param g
	 */
	public AlgorithmTest() {
		stronglyConnectedComponents = new ArrayList<>();
		visitedVertices = new HashSet<>();
		finishedVertices = new Stack<>();
		
		firstDFS = new LinkedList<>();
		secondDFS = new LinkedList<>();
		
		discoveryTimes = new HashMap<>();
		finishingTimes = new HashMap<>();
		
		time = 0;
	}
	
	@Override
	public void init(Graph graph) {
		this.graph = (DirectedGraph) graph;
		transposedGraph = this.graph.getTransposedGraph();
		System.err.println(this.graph);
	}

	/**
	 * 
	 * @return strongly connected components of graph
	 */
	@Override
	public void compute() {
		for (Vertex v : graph.getVertices()) {
			if (!visitedVertices.contains(v)) {
				dfsVisit(graph, v, false, null);
			}
		}

		visitedVertices.clear();

		while (!finishedVertices.empty()) {
			Vertex v = finishedVertices.pop();
			ArrayList<Vertex> set = new ArrayList<>();
			stronglyConnectedComponents.add(set);
			if (!visitedVertices.contains(v)) {
				dfsVisit(transposedGraph, v, true, set);
			}
		}
		
		// Remove empty lists inside stronglyConnectedComponents due to implementation issues
		stronglyConnectedComponents.removeIf(c -> c.isEmpty());

	}

	private void dfsVisit(DirectedGraph g, Vertex v, boolean isSecondRun, ArrayList<Vertex> set) {
		currentVertex = v;
		if(isSecondRun) {
			secondDFS.add(v);
		} else {
			firstDFS.add(v);
			discoveryTimes.put(v, time);
			time++;
		}
		
		visitedVertices.add(v);
		if (isSecondRun) {
			set.add(v);
		}
		
		for (Vertex vertex : g.getTargetsOfVertex(v)) {
			if (!visitedVertices.contains(vertex)) {
				dfsVisit(g, vertex, isSecondRun, set);
			}
		}

		if (!isSecondRun) {
			finishedVertices.push(v);
			finishingTimes.put(v, time);
			time++;
		}

	}
	
	public List<Vertex> getFirstDFS() {
		return firstDFS;
	}

	public List<Vertex> getSecondDFS() {
		return secondDFS;
	}


	/**
	 * @return a list containing all strongly connected components in capsulated lists
	 */
	public List<ArrayList<Vertex>> getStronglyConnectedComponents() {
		return stronglyConnectedComponents;
	}

	/**
	 * @return a map that matches all vertices of the graph to their discovery time of the first DFS
	 */
	public Map<Vertex, Integer> getDiscoveryTimes() {
		return discoveryTimes;
	}

	/**
	 * @return  a map that matches all vertices of the graph to their finishing time of the first DFS
	 */
	public Map<Vertex, Integer> getFinishingTimes() {
		return finishingTimes;
	}

}

