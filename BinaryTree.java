public class BinaryTree {
	
	/*
	 * Copy your code for the BinaryTree class from the previous project.
	 * Then modify the code so that it handles records that are strings
	 * rather than integers.
	 *
	 * Be particularly careful of comparisons and tests for equality.
	 * Be sure to use the appropriate string methods rather than
	 * ==, <, >, etc.
	 */		
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/*
	 * Methods to insert a new node into the tree.
	 * 
	 * insertNode inserts a new node into the subtree with root
	 * node topNode and returns the new tree structure back with the
	 * same root node.
	 * 
	 * insert is the public interface to the subtreeInsert method and will
	 * be the method actually invoked by the calling program.  Methods like
	 * it are often called "wrapper" methods because they "wrap" the private
	 * methods that do all of the work in a more convenient interface.
	 */
	public void insert(String newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, String newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord.compareTo(topNode.record) <= 0) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	
	/*
	 * Methods to perform an in-order tree traversal.
	 * 
	 * The inOrderSubtree method does all of the work, with inOrder
	 * serving as a wrapper method (see above).
	 */
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a pre-order traversal.
	 */
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null){
			return;
		}
		else{
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a post-order traversal.
	 */
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null){
			return;
		}
		else{
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	
	/*
	 * Methods to calculate the size (number of nodes) in a tree.
	 */
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null){
        return 0;
		}
		else{
        return(subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1);
		}
	}
	
	/*
	 * Methods to calculate the maximum depth of a tree.
	 */
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if(topNode == null){
			return 0;
		}
		else{
			int MaxLeft = subtreeMaxDepth(topNode.left);
            int MaxRight = subtreeMaxDepth(topNode.right);
            
			if(MaxLeft > MaxRight){
				return MaxLeft + 1;
			}
			else{
				return MaxRight + 1;
			}
		}
	}
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode){
		if(topNode == null){
			return 0;
		}
		else{
			int minLeft = subtreeMinDepth(topNode.left);
			int minRight = subtreeMinDepth(topNode.right);
			
			if(minLeft > minRight){
				return  minRight + 1;
			}
			else{
				return  minLeft + 1;
			}
			
		}
	}
	public int countMatches(String key){
		return subtreeCountMatches(root, key);
	}
	private int subtreeCountMatches(Node topNode, String key){
		int num = 0;
		if(topNode == null){
			return 0;
		}
		else{
			int i = subtreeCountMatches(topNode.left, key);
			int j = subtreeCountMatches(topNode.right, key);
			
			if(topNode.record.equals(key)){
				num++;
			}
			{
				return num + i + j; 
			}
			
		}
	}

	public String maxRecord(){
		return subtreeMaxRecord(root);
	}
	private String subtreeMaxRecord(Node topNode){
		if(topNode == null){
			return null;
		}
		else{
			String i = topNode.record;

			if(null != topNode.record){
				i = subtreeMaxRecord(topNode.right);				
			}
			return i;
		}
	}
	public String minRecord(){
		return subtreeMinRecord(root);
	}
	private String subtreeMinRecord(Node topNode){
		if(topNode == null){
			return null;
		}
		else{
			String i = topNode.record;

			if(null != topNode.left){
				i =  subtreeMinRecord(topNode.left);				
			}
			return i;
		}
	}
}