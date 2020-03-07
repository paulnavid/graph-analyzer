package graphanalyzer.model.algorithms;

import graphanalyzer.model.graph.Graph;

/**
 * An algorithm is a class that is used to compute a specific algorithm on a
 * given graph or its elements. An algorithm has to implement at least two
 * methods:
 * <ul>
 * <li>{@link #init(Graph)} - initialize the specific algorithm</li>
 * <li>{@link #compute()} - computes the algorithm</li>
 * </ul>
 *
 * @author paulehler
 *
 */
public interface Algorithm {
	/**
	 * Initialize the algorithm.
	 * <p>
	 * This method has to be called first after declaring the algorithm.
	 * 
	 * @param graph a graph to perform the algorithm on
	 */
	void init(Graph graph);

	/**
	 * Compute the algorithm.
	 * <p>
	 * Before computing the {@link #init(Graph)} method has to be called first.
	 * 
	 * @see #init(Graph)
	 */
	void compute();
}
