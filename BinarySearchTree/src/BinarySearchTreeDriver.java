import java.util.ArrayList;
import java.util.List;


public class BinarySearchTreeDriver {

	public static void main(String[] args) 
	{
		
		List<String> list = new ArrayList<String>();
		
//		list = null;
		
		System.out.println("list: " + list.size());

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		Node root = null;
		root = bst.insert(root, 10);
		root = bst.insert(root, 5);
		root = bst.insert(root, 16);
		root = bst.insert(root, 12);
		root = bst.insert(root, 18);
		root = bst.insert(root, 4);
		root = bst.insert(root, 6);
		root = bst.insert(root, 8);
		root = bst.insert(root, 50);

//		bst.printInOrder(root);
//		System.out.println("inorder=" +bst.inorderSuccessor(root, root));
//		System.out.println("Found= " +bst.lookup(root,4));
//		System.out.println("Size= " +bst.size(root));
//		System.out.println("maxDepth= " +bst.maxDepth(root));
//		System.out.println("minValue= " +bst.minValue(root));
//		System.out.println("hasPathSum= " +bst.hasPathSum(root,52));
		
//		System.out.println("Level order:");
//		bst.printLevelOrder(root);
		
//		System.out.println("sumOfAllNodesOdd=" + bst.sumOfAllNodesOdd(root));
		
//		System.out.println("maxLevelSum=" + bst.maxLevelSum(root));
		
//		System.out.println("kthSmallest=" + bst.kthSmallest(root,3));
//		bst.kthSmallest(root,0,3);
		
//		bst.printKrange(root, 4, 12);
//		System.out.println("preOrderIterative=");
//		bst.preOrderIterative(root);
		
//		bst.inOrderIterative(root);
		
//		System.out.println((bst.printkthLargest(root,2)).getData());
		
//		bst.preOrderIterativePractice1(root);
		
//		bst.postOrderIterativePractice1(root);
	}
}
