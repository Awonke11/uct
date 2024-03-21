package lib;

/**
 * Hussein's Binary Tree Node
 * Author: Hussein Suleman
 * Date: 26 March 2017
 */
public class BinaryTreeNode
{
   DataType data;
   BinaryTreeNode left;
   BinaryTreeNode right;
   int height;
   
   /**
    * Constructor
    * @param d
    * @param l
    * @param r
    */
   public BinaryTreeNode ( DataType d, BinaryTreeNode l, BinaryTreeNode r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }

   /**
    * Get the data stored in the node
    * @return
    */
   public DataType getData () { return data; }
   
   /**
    * Get the left node
    * @return
    */
   public BinaryTreeNode getLeft () { return left; }

   /**
    * Get the right node
    * @return
    */
   public BinaryTreeNode getRight () { return right; }
}
