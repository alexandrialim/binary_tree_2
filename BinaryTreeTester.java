/**
 * This is a tester program for the BinaryTree class
 * @author Michael Ida
 *
 */
public class BinaryTreeTester {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		int[] inputData = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
		
		for (int elem : inputData) {
			tree.insert(elem);
		}
		
		System.out.println("In-Order Traversal");
		tree.inOrder();
		System.out.println("\n\n");
		// should be: -150, -5, 0, 12, 15, 20, 20, 25, 100, 126, 200, 1000
		
		System.out.println("Pre-Order Traversal");
		tree.preOrder();
		System.out.println("\n\n");
		// should be: 20, 15, -5, -150, 0, 12, 200, 25, 20, 100, 126, 1000
		
		System.out.println("Post-Order Traversal");
		tree.postOrder();
		System.out.println("\n\n");
		// should be: -150, 12, 0, -5, 15, 20, 126, 100, 25, 1000, 200, 20
		
		System.out.println("Size: " + tree.size());
		System.out.println("\n");
		// should be: 12
		
		System.out.println("Maximum Depth: " + tree.maxDepth());
		System.out.println("\n");
		//should be: 5
		
		System.out.println("Minimum Depth: " + tree.minDepth());
		System.out.println("\n");
		
		System.out.println("Count Match:"+ " 20" +" is counted " + tree.countMatches(20) + " times");
		System.out.println("\n");
		
		System.out.println("Max record: " + tree.maxRecord());
		System.out.println("\n");
		
		System.out.println("Min record: " + tree.minRecord());
		System.out.println("\n");
	}

}
