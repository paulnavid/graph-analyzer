package graphanalyzer.util.io;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import graphanalyzer.model.graph.Graph;
import graphanalyzer.model.graph.Vertex;

/**
 * Reader for graphs provided in form of a GraphML file.
 * 
 * @see <a href="http://graphml.graphdrawing.org/">The GraphML File Format</a>
 * 
 * @author paulehler
 *
 */
public class GraphMLReader {
	
	private Graph graph;

	/**
	 * Constructor of GraphhMLReader.
	 * 
	 * @param graph
	 */
	public GraphMLReader(Graph graph) {
		this.graph = graph;
	}
	
	
	/**
	 * Reads the given inputStream of a GraphML file and initializes the Graph.
	 * 
	 * @param graphmlInputStream
	 */
	public boolean readInput(InputStream graphmlInputStream) {
		
		HashMap<String, Vertex> mapIdToVertex = new HashMap<>();
		
		try {

			InputStream inputStream = graphmlInputStream;
			DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
			dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Prevention of XXE attacks
			dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // Prevention of XXE attacks
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(inputStream));
			
			doc.getDocumentElement().normalize(); // Remove possible formatting errors and redundancies
			
			// Get all vertices
			NodeList nodeList = doc.getElementsByTagName(GraphMLElements.NODE);
			
			for (int temp = 0; temp < nodeList.getLength(); temp++) {

				Node nNode = nodeList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					NamedNodeMap attributes = nNode.getAttributes();
					String id = attributes.getNamedItem(GraphMLElements.ID).getNodeValue();
					NodeList dataList = eElement.getElementsByTagName(GraphMLElements.DATA);
					Vertex vertex = null;
					
					for (int i = 0; i < dataList.getLength(); i++) {
						Node dataNode = dataList.item(i);
						
						if (GraphMLElements.LABEL.equals(dataNode.getAttributes().getNamedItem(GraphMLElements.KEY).getTextContent())) {
							vertex = new Vertex(dataNode.getTextContent());
						}
	
					}
		
					mapIdToVertex.put(id, vertex);
					graph.addVertex(vertex);

				}

			}
			
			// Get all edges
			NodeList edgeList = doc.getElementsByTagName(GraphMLElements.EDGE);
			
			for (int temp = 0; temp < edgeList.getLength(); temp++) {
				Node nNode = edgeList.item(temp);

				String source = nNode.getAttributes().getNamedItem(GraphMLElements.SOURCE).getNodeValue();
				String target = nNode.getAttributes().getNamedItem(GraphMLElements.TARGET).getNodeValue();
				
				graph.addEdge(mapIdToVertex.get(source), mapIdToVertex.get(target));
			}
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
