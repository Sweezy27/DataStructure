
public class GraphNode {

	// create name and mark variables store the data
	private int name;
	private boolean mark;

	// initial the node by name of node and set mark as false
	public GraphNode(int name) {
		this.name = name;
		this.mark = false;
	}

	// set the mark of the node
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	// return the mark in the node
	public boolean getMark() {
		return this.mark;
	}

	// return the name of the node
	public int getName() {
		return this.name;
	}
}
