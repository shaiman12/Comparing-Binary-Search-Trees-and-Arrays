
public class BinarySearchTree<dataType> {
	private BinaryTreeNode<dataType> root;

	 public BinarySearchTree ()
	 {
	 root = null;
	 }

	 public int getHeight ( BinaryTreeNode<dataType> node )
	 {
	 if (node == null)
	 return -1;
	 else {
	 return 1 + Math.max (getHeight (node.getLeft ()),getHeight (node.getRight ()));
	 }
	 } 
	 
	 
	 public int getSize ()
	 {
	 return getSize (root);
	 } 
	 
	 
	 public int getSize ( BinaryTreeNode<dataType> node )
	 {
	 if (node == null)
	 return 0;
	 else
	 return 1 + getSize (node.getLeft ()) +
	 getSize (node.getRight ());
	 }
	 
	 
	 public void visit ( BinaryTreeNode<dataType> node )
	 {
	 System.out.println (node.toString());
	 }
	 
	 public void inOrder ()
	 {
	 inOrder (root);
	 }
	 
	 public void inOrder ( BinaryTreeNode<dataType> node )
	 {
	 if (node != null)
	 {
	 inOrder (node.getLeft ());
	 visit (node);
	 inOrder (node.getRight ());
	 }
	 }
	 
	 public void postOrder ()
	 {
	 postOrder (root);
	 }
	 
	 public void postOrder ( BinaryTreeNode<dataType> node )
	 {
	 if (node != null)
	 {
	 postOrder (node.getLeft ());
	 postOrder (node.getRight ());
	 visit (node);
	 }
	 }
	 
	 public void insert ( dataType d )
	 {
	 if (root == null)
	 root = new BinaryTreeNode<dataType> (d, null, null);
	 else
	 insert (d, root);
	 }
	 
	 public void insert ( dataType d, BinaryTreeNode<dataType> node )
	 {
	 if (d.toString().compareTo (node.toString()) <= 0)
	 {
	 if (node.left == null)
	 node.left = new BinaryTreeNode<dataType> (d, null, null);
	 else
	 insert (d, node.left);
	 }
	 else
	 {
	 if (node.right == null)
	 node.right = new BinaryTreeNode<dataType> (d, null, null);
	 else
	 insert (d, node.right);
	 }
	 }
	 
	 
	 
	 
	 
	 public String find ( String d )
	 {
	 if (root == null)
	 return null;
	 else
	 return find (d, root);
	 }
	 
	 public String find ( String d, BinaryTreeNode<dataType> node )
	 {
	 if (d.toString().compareTo (node.toString()) == 0)
	 return node.toString();
	 else if (d.toString().compareTo (node.toString()) < 0)
	 return (node.left == null) ? null : find (d, node.left);
	 else
	 return (node.right == null) ? null : find (d, node.right);
	 }
	 
}//end of class
