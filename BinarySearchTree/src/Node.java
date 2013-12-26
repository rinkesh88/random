
public class Node {

	private Node left;
	private Node right;
	private int data;
	
	Node (int newData)
	{
		this.setLeft(null);
		this.setRight(null);
		this.data = newData;
	}
	
	public Node() 
	{
		
	}

	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
