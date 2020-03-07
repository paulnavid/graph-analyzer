package graphanalyzer.view.components;

public interface EdgeComponent {
	
	void drawComponent();
	
	VertexComponent getSource();
	
	VertexComponent getTarget();
	
}
