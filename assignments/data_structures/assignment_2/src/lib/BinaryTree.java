package lib;

/**
 * Hussein's Binary Tree
 * Author: Hussein Suleman
 * Date: 26 March 2017
 */
public class BinaryTree
{
   BinaryTreeNode root;
   
   /**
    * Constructor
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Get the height of the tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   

   /**
    * Get the height of the tree
    * @param node
    * @return the height of the tree
    */
   public int getHeight ( BinaryTreeNode node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }

   /**
    * Get the size of the tree
    */
   public int getSize ()
   {
      return getSize (root);
   }   

   /**
    * Get the size of the tree
    * @param node
    * @return the size of the tree
    */
   public int getSize ( BinaryTreeNode node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * Visit the node
    * @param node
    */
   public void visit ( BinaryTreeNode node )
   {
      System.out.println (node.data);
   }
   
   /** 
    * Pre order traversal
   */
   public void preOrder ()
   {
      preOrder (root);
   }

   /**
    * Pre order traversal
    * @param node
    */
   public void preOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   /** 
    * Post order traversal
   */
   public void postOrder ()
   {
      postOrder (root);
   }

   /**
    * Post order traversal
    * @param node
    */
   public void postOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /** 
    * In order traversal
   */
   public void inOrder ()
   {
      inOrder (root);
   }

   /**
    * In order traversal
    * @param node
    */
   public void inOrder ( BinaryTreeNode node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   /**
    * Level order traversal
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue q = new BTQueue ();
      q.enQueue (root);
      BinaryTreeNode node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
