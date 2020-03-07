package graphanalyzer.view.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * This class represents the graphical form of a Vertex.
 * 
 * @author paulehler
 *
 */
public class LabeledVertexComponent implements VertexComponent{
	
	private Point point;
	private String label;
	private Color fillColor;
	private Color borderColor;
	private Color labelColor = Color.BLACK;
	
	
	/**
	 * Constructor of LabeledVertexComponent.
	 * 
	 * @param label
	 * @param coordinates
	 * @param fillColor
	 * @param borderColor
	 */
	public LabeledVertexComponent(String label, Point coordinates, Color fillColor, Color borderColor) {
		this.label = label;
		this.point = coordinates;
		this.fillColor = fillColor;
		this.borderColor = borderColor;
	}
	
	/**
	 * Draw the vertex with given diameter.
	 * 
	 * @param graphics graphics
	 * @param vertexDiameter diameter of the vertex
	 */
	public void drawComponent(Graphics2D graphics, int vertexDiameter) {
		
		// Fill vertex
		graphics.setColor(fillColor);
		graphics.fillOval((int) point.getX(), (int) point.getY(), vertexDiameter, vertexDiameter);
		// Border vertex
		graphics.setColor(borderColor);
		graphics.drawOval((int) point.getX(), (int) point.getY(), vertexDiameter, vertexDiameter);
		// Label vertex
		graphics.setColor(labelColor);
		// Center text in vertex
		FontMetrics metrics = graphics.getFontMetrics();
		int textX = (int) (point.getX() + (vertexDiameter - metrics.stringWidth(label)) / 2d);
		int textY = (int) (point.getY() + ((vertexDiameter - metrics.getHeight()) / 2d + metrics.getAscent()));
		graphics.drawString(label, textX, textY);
		
	}
	
	/**
	 * Sets vertex fill and border color.
	 * 
	 * @param newFillColor fill color
	 * @param newBorderColor border color
	 */
	public void setColor(Color newFillColor, Color newBorderColor) {
		this.fillColor = newFillColor;
		this.borderColor = newBorderColor;
	}

	/**
	 * Sets new vertex border color.
	 * 
	 * @param newBorderColor border color
	 */
	public void setBorderColor(Color newBorderColor) {
		this.borderColor = newBorderColor;
	}
	
	/**
	 * Sets the vertex coordinates.
	 * 
	 * @param coordinates new coordinates
	 */
	public void setCoordinates(Point coordinates) {
		this.point = coordinates;
	}
	
	/**
	 * Get coordinates of the vertex as Point.
	 */
	public Point getCoordinates() {
		return point;
	}
	

	/**
	 * @return x-coordinate of vertex position
	 */
	public int getX() {
		return (int) point.getX();
	}
	
	/**
	 * @return y-coordinate of vertex position
	 */
	public int getY() {
		return (int) point.getY();
	}
	
	
}
