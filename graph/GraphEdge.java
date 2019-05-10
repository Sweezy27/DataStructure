
public class GraphEdge {

	// create variables to store the data
	private GraphNode first;
	private GraphNode second;
	private char busLine;

	// initialize the edge by two node and the busline
	public GraphEdge(GraphNode u, GraphNode v, char busLine) {
		this.first = u;
		this.second = v;
		this.busLine = busLine;
	}

	// return the first endpoint as a node
	public GraphNode firstEndpoint() {
		return this.first;
	}

	// return the second endpoint as a node
	public GraphNode secondEndpoint() {
		return this.second;
	}

	// return the bus line in the edge
	public char getBusLine() {
		return this.busLine;
	}
}
