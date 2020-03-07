package graphanalyzer.controller.routines;

import java.io.Serializable;

/**
 * A routine for iteration over a specific algorithm.
 * <p>
 * The user of this interface can implement a specific graph algorithm routine and make it steppable. 
 * This interface provides two methods for classes that implement it:
 * <ol>
 * <li>{@link #nextStep()}</li>
 * <li>{@link #previousStep()}</li>
 * </ol>
 * 
 * @author paulehler
 *
 */
public interface AlgorithmRoutine extends Serializable {
	
	/**
	 * Iterates to the next step of the implemented algorithm.
	 * 
	 * Based on the current state of the routine the GUI gets updated.
	 */
	void nextStep();
	
	/**
	 * Iterates to the previous step of the implemented algorithm.
	 * 
	 * Based on the current state of the routine the GUI gets updated.
	 */
	void previousStep();
}
