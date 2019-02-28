
public class BinaryTreeNode<dataType> {
	private dataType data;
	 BinaryTreeNode<dataType> left;
	 BinaryTreeNode<dataType> right;

	
	
	
	public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l,
			BinaryTreeNode<dataType> r )
			 {
			 data = d;
			 left = l;
			 right = r;
			 }

	BinaryTreeNode<dataType> getLeft () { 
		return left; 
		}
	
	
	 BinaryTreeNode<dataType> getRight () { 
		 return right; 
		 }


	 public String toString() {
			return data.toString();
		}













}//end of class
