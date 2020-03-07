package graphanalyzer.model.graph;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents a vertex.
 * 
 * @author paulehler
 *
 */
public class Vertex implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2955252371096742374L;
	private String label;
	private boolean visited = false;

	/**
	 * Initialize a Vertex with passed label.
	 * 
	 * @param label
	 */
	public Vertex(String label) {
		this.label = label;
	}
	
	/**
	 * @return the vertex' label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * @return if vertex has been visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited whether the vertex should me marked as visited or not
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return this.label;
	}
	
	/**
	 * To ensure comparing two vertices works as expected.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	/**
	 * To ensure comparing two vertices works as expected.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
        if (!(obj instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) obj;
        return Objects.equals(label, vertex.label);
	}

}
