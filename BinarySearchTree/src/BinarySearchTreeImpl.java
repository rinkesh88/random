import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeImpl {
	
	
	public void BinaryTree() 
	{
	}
	
	public boolean lookup(Node root, int data)
	{
		if (root == null)
			return false;
		if (data == root.getData())
		{
			return true;
		}
		else if (data < root.getData())
		{
			return lookup(root.getLeft(),data);
		}
		else
		{
			return lookup(root.getRight(),data);
		}
	}
	
	public Node insert (Node root, int data)
	{
		if (root == null)
		{
			root = new Node(data);
		}
		else 
		{
			if (data <= root.getData())
			{
				root.setLeft(insert(root.getLeft(), data));
			}
			else
			{
				root.setRight(insert(root.getRight(), data));
			}
		}
		return root;
	}
	
	public void printInOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		else
		{
			printInOrder(root.getLeft());
			System.out.println(root.getData());
			printInOrder(root.getRight());
		}
	}
	
	public int inorderSuccessor(Node root, Node succ)
	{
		Node p = null;

		if (root == null)
		{
			return -1;
		}
		else
		{
			if (succ.getRight() != null)
			{
				return minValue(succ.getRight());
			}
			while (root != null)
			{
				if (succ.getData() < root.getData())
				{
					p = root;
					root = root.getLeft();
				}
				else if (succ.getData() > root.getData())
					root = root.getRight();
				else break;
			}
		}
		if (p != null)
			return p.getData();
		else
			return -1;
	}
	
	public int minValue(Node root)
	{
		if (root == null)
		{
			return -1;
		}
		else
		{
			while (root.getLeft() != null)
				root = root.getLeft();
			return root.getData();
		}
	}
	
	public int size(Node root)
	{
		if (root == null)
			return 0;
		else
			return size(root.getLeft()) + 1 + size(root.getRight());
	}
	
	public int maxDepth(Node root)
	{
		if (root == null)
			return 0;
		else
		{
			int lDepth = maxDepth(root.getLeft());
			int rDepth = maxDepth(root.getRight());
			
			return(Math.max(lDepth, rDepth) + 1);
		}
	}
	
	public boolean hasPathSum(Node root, int sum)
	{
		if (root == null)
			return (sum==0);
		else
		{
			int subSum = sum-root.getData();
			return (hasPathSum(root.getLeft(),subSum) || hasPathSum(root.getRight(),subSum));
		}
	}
	
	public void printLevelOrder(Node root)
	{
		if (root == null)
			return;
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty())
		{
			Node first = queue.poll();
			System.out.println(first.getData());
			
			if (first.getLeft() != null) queue.add(first.getLeft());
			if (first.getRight() != null) queue.add(first.getRight());
		}
	}
	
	public boolean sumOfAllNodesOdd(Node root)
	{
		if (root == null)
			return false;
		
		int total = 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty())
		{
			Node first = queue.poll();
			total += first.getData();
			
			if (first.getLeft() != null) queue.add(first.getLeft());
			if (first.getRight() != null) queue.add(first.getRight());
		}
		System.out.println("total sum=" + total);
		if (total%2 == 0)
			return false;
		else
			return true;
	}
	
	public int maxLevelSum(Node root)
	{
		if (root == null)
			return -1;
		
		int total = 0;
		int max = 0;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		while (queue.peek() != null)
		{
			System.out.println("Level order:");
			total = 0;
			while (queue.peek() != null)
			{
				Node first = queue.poll();
				total += first.getData();
				
				if (first.getLeft() != null) queue.add(first.getLeft());
				if (first.getRight() != null) queue.add(first.getRight());
			}
			if (total > max)
				max = total;
			
			queue.remove();
			queue.add(null);
		}
		return max;
	}
	
	public void kthSmallest(Node root, int count, int k)
	{
		if (root == null)
			return;
		else
		{
			kthSmallest(root.getLeft(), count, k);
			count++;
			if (k==count)
				System.out.println("kthSmallest=" + root.getData());
			kthSmallest(root.getRight(), count, k);
		}
	
	}
	
	public void printKrange(Node root, final int start, final int end)
	{
		if (root == null)
			return;
		
		printKrange(root.getLeft(), start, end);
		if (root.getData() > start && root.getData() < end)
			System.out.println("printKrange=" + root.getData());
		printKrange(root.getRight(), start, end);
	}
	
	public void preOrderIterative (Node root)
	{
		if (root == null)
		{
			return;
		}
		
		Stack<Node> st = new Stack<Node>();
		
		st.push(root);
		
		while (!st.isEmpty())
		{
			Node temp = st.pop();
			System.out.println(temp.getData());
		
			if (temp.getRight() != null)
			{
				st.push(temp.getRight());
			}
			
			if (temp.getLeft() != null)
			{
				st.push(temp.getLeft());
			}
		}
	}
	
	
	public void inOrderIterative(Node root)
	{
	  Node current = root;
	  Stack<Node> s = new Stack<Node>();
	  boolean done = false;
	 
	  while (!done)
	  {
	    if(current !=  null)
	    {
	      s.push(current);                                              
	      current = current.getLeft(); 
	    }
	    else                                                             
	    {
	      if (!s.isEmpty())
	      {
	        current = s.pop();
	        System.out.println(current.getData());
	        current = current.getRight();
	      }
	      else
	        done = true;
	    }
	  }
	}
	
	public Node printkthSmallest(Node root, int k)
	{
	  Node current = root;
	  Stack<Node> s = new Stack<Node>();
	  boolean done = false;
	 
	  while (!done)
	  {
	    if(current !=  null)
	    {
	      s.push(current);                                              
	      current = current.getLeft(); 
	    }
	    else                                                             
	    {
	      if (!s.isEmpty())
	      {
	        current = s.pop();
	        if (--k == 0) 
	        	return current;
	        current = current.getRight();
	      }
	      else
	        done = true;
	    }
	  }
	return current;
	}  
	
	public Node printkthLargest(Node root, int k)
	{
	  Node current = root;
	  Stack<Node> s = new Stack<Node>();
	  boolean done = false;
	 
	  while (!done)
	  {
	    if(current !=  null)
	    {
	      s.push(current);                                              
	      current = current.getRight(); 
	    }
	    else                                                             
	    {
	      if (!s.isEmpty())
	      {
	        current = s.pop();
	        if (--k == 0) 
	        	return current;
	        current = current.getLeft();
	      }
	      else
	        done = true;
	    }
	  }
	return current;
	}  
	
	public void preOrderIterativePractice1(Node root)
	{
		if (root == null)
			return;
		
		Stack<Node> st = new Stack<Node>();
		
		st.push(root);
		
		while (!st.isEmpty())
		{
			Node temp = st.pop();
			System.out.println(temp.getData());
			
			if (temp.getRight() != null)
			{
				st.push(temp.getRight());
			}
			
			if (temp.getLeft() != null)
			{
				st.push(temp.getLeft());
			}
		}
	}
	
	public void postOrderIterativePractice1(Node root)
	{
		if (root == null)
			return;
		
		Stack<Node> st = new Stack<Node>();
		
		do
		{
			while (root != null)
			{
				if (root.getRight() != null)
					st.push(root.getRight());
				
				st.push(root);
				
				root = root.getLeft();
			}
			
			root = st.pop();
			
			if (root.getRight() != null && !st.isEmpty() && root.getRight() == st.peek())
			{
				st.pop();
				st.push(root);
				root = root.getRight();
			}
			else
			{
				System.out.println(root.getData());
				root = null;
			}
		}while (!st.isEmpty());
		
	}
}
