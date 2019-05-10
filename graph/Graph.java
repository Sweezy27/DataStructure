import java.util.Iterator;

public class Graph implements GraphADT {

	// create a node array store the node in the graph
	private GraphNode V[];
	// create a 2D edge array store the edges in the graph using adjacency matrix
	private GraphEdge E[][];
	private int size;

	// initialize the graph by a given size
	// meanwhile, initialize all the nodes in the graph
	public Graph(int n) {
		this.V = new GraphNode[n];
		this.E = new GraphEdge[n][n];
		this.size = n;
		for (int i = 0; i < size; i++) {
			// initialize all the nodes
			V[i] = new GraphNode(i);
		}
	}

	// insert function to insert a edge to the graph
	// In: two nodes and bus line
	public void insertEdge(GraphNode nodeu, GraphNode nodev, char busLine) throws GraphException {
		// check whether the node in the graph
		if (nodeu.getName() >= size) {
			throw new GraphException("The " + nodeu.getName() + " is not in the graph.");
		} else if (nodev.getName() >= size) {
			throw new GraphException("The " + nodev.getName() + " is not in the graph.");
		}
		// then, add the edge to the graph
		else {
			GraphEdge new1 = new GraphEdge(nodeu, nodev, busLine);
			GraphEdge new2 = new GraphEdge(nodev, nodeu, busLine);
			E[nodeu.getName()][nodev.getName()] = new1;
			E[nodev.getName()][nodeu.getName()] = new2;
		}
	}

	// get the node in the graph
	// In: a name of node
	// Out: return a node which has the same name, otherwise throw a graph exception
	public GraphNode getNode(int name) throws GraphException {
		// check whether the node in the graph
		if (name >= size) {
			throw new GraphException("The " + name + " is not in the graph.");
		} else {
			return V[name];
		}
	}

	// find all the edge for a give node
	// In: a node u
	// Out: a iterator contains all the edges of node u
	// if no edge, return null
	public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException {
		// check whether the node in the graph
		if (u.getName() >= size) {
			throw new GraphException("The " + u.getName() + " is not in the graph.");
		} else {
			// using stack to store the edge first
			Stack<GraphEdge> stack = new Stack<GraphEdge>();
			int i = 0;
			// if the edge exist, add it in the stack
			while (i < size) {
				if (E[u.getName()][i] != null) {
					stack.push(E[u.getName()][i]);
				}
				i++;
			}
			// if the stack is empty, return null
			// otherwise, return the iterator of the stack
			if (stack.isEmpty()) {
				return null;
			} else {
				return stack.iterator();
			}
		}
	}

	// find the edge between two node if the bus line exist
	public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException {
		// check whether the node in the graph
		if (u.getName() >= size) {
			throw new GraphException("The " + u.getName() + " is not in the graph.");
		} else if (v.getName() >= size) {
			throw new GraphException("The " + v.getName() + " is not in the graph.");
		} else {
			// check the edge exist or not
			if (E[u.getName()][v.getName()] != null) {
				return E[u.getName()][v.getName()];
			}
			// if no bus line between, throw a exception
			else {
				throw new GraphException(
						"The edge between " + u.getName() + " and " + v.getName() + " is not in the graph.");
			}
		}
	}

	// check whether adjacent between two node
	// return true, if they are adjacent
	// otherwise, return false
	public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {
		if (u.getName() >= size) {
			throw new GraphException("The " + u.getName() + " is not in the graph.");
		} else if (v.getName() >= size) {
			throw new GraphException("The " + v.getName() + " is not in the graph.");
		} else {
			// check the edge exist or not
			if (E[u.getName()][v.getName()] != null) {
				return true;
			} else {
				return false;
			}
		}
	}

}
