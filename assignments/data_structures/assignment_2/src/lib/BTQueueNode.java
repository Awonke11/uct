package lib;

/**
 * Hussein's BTQueue Node
 * Author: Hussein Suleman
 * Date: 26 March 2017
 */
public class BTQueueNode
{
   BinaryTreeNode node;
   BTQueueNode next;
   
   /**
    * Constructor
    * @param n
    * @param nxt
    */
   public BTQueueNode ( BinaryTreeNode n, BTQueueNode nxt )
   {
      node = n;
      next = nxt;
   }
}
