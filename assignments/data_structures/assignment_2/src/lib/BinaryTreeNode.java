package lib;

/**
 * Hussein's Binary Tree Node
 * Author: Hussein Suleman
 * Edited: Awonke Mnotoza
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
    * @param d the data
    * @param l the left node
    * @param r the right node
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
    * @return the data
    */
   public DataType getData () { return data; }
   
   /**
    * Get the left node
    * @return the left
    */
   public BinaryTreeNode getLeft () { return left; }

   /**
    * Get the right node
    * @return the right
    */
   public BinaryTreeNode getRight () { return right; }
}
